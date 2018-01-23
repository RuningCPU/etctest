package com.wintime;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;




public class TestProducer extends Thread{

    private String topic;

    public TestProducer(String topic){
        super();
        this.topic = topic;
    }


    @Override
    public void run() {
        Producer producer = createProducer();
        int i=0;
        while(true){
            producer.send(new KeyedMessage<Integer, String>(topic, "message: " + i++));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Producer createProducer() {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", "hdp01:2181,hdp02:2181,hdp03:2181");//声明zk
        properties.put("serializer.class", StringEncoder.class.getName());
        properties.put("metadata.broker.list", "hdp01:6667,hdp02:6667,hdp03:6667");// 声明kafka broker
        return new Producer<Integer, String>(new ProducerConfig(properties));
    }


    public static void main(String[] args) {
        new TestProducer("test").start();// 使用kafka集群中创建好的主题 test

    }

}
