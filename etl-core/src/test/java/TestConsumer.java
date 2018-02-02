import java.util.*;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringEncoder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


/**
 * 接收数据 
 * 接收到: message: 10 
 接收到: message: 11 
 接收到: message: 12 
 接收到: message: 13 
 接收到: message: 14 
 * @author zm
 *
 */
public class TestConsumer extends Thread{

    private String topic;

    public TestConsumer(String topic){
        super();
        this.topic = topic;
    }


    @Override
    public void run() {
        ConsumerConnector consumer = createConsumer();
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, 1); // 一次从主题中获取一个数据  
        Map<String, List<KafkaStream<byte[], byte[]>>>  messageStreams = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = messageStreams.get(topic).get(0);// 获取每次接收到的这个数据  
        ConsumerIterator<byte[], byte[]> iterator =  stream.iterator();
//        while(iterator.hasNext()){
//            String message = new String(iterator.next().message());
//            System.out.println("接收到: " + message);
//        }
    }

    private ConsumerConnector createConsumer() {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", "hdp01:2181,hdp02:2181,hdp03:2181");//声明zk
        properties.put("group.id", "group1");// 必须要使用别的组名称， 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据
        return Consumer.createJavaConsumerConnector(new ConsumerConfig(properties));
    }


    public static void main(String[] args) {
//       new TestConsumer("test").start();// 使用kafka集群中创建好的主题 test
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "hdp01:6667,hdp03:6667,hdp03:6667");
//        props.put("zookeeper.connect", "hdp01:2181,hdp02:2181,hdp03:2181");//声明zk
//        props.put("group.id", "test");
//        props.put("enable.auto.commit", "false");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("session.timeout.ms", "300");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Arrays.asList("foo", "bar"));
//        final int minBatchSize = 200;
//        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
//
//            System.out.println("shuchu");
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                buffer.add(record);
//            }
//            if (buffer.size() <= minBatchSize) {
//                System.out.println(buffer.toArray());
//                consumer.commitSync();
//                buffer.clear();
//            }


        Properties props = new Properties();
        props.put("bootstrap.servers", "hdp01:9092,hdp03:9092,hdp03:9092");
       // props.put("serializer.class", StringEncoder.class.getName());
        //props.put("zookeeper.connect", "hdp01:2181,hdp02:2181,hdp03:2181");//声明zk
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "600");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<Integer, String> consumer = new KafkaConsumer(props);
        consumer.subscribe(Arrays.asList("foo", "bar"));
        while (true) {
            System.out.println("start");
            ConsumerRecords<Integer, String> records = consumer.poll(10);
            for (ConsumerRecord<Integer, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            System.out.println("end");
        }

    }
}