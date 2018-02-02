public class JavaDirectKafkaWordCount {
    public static void main(String[] args) throws Exception {
//        String brokers = args[0];
//        String topics = args[1];
//        // Create context with a 2 seconds batch interval
//        /**         * setMaster("local[2]")，至少要指定两个线程，一条用于用于接收消息，一条线程用于处理消息30.		 */
//        SparkConf sparkConf = new SparkConf().setAppName("JavaDirectKafkaWordCount").setMaster("local[2]");
//        JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, Durations.seconds(2));
//        Set<String> topicsSet = new HashSet<>(Arrays.asList("test"));
//        Map<String, String> kafkaParams = new HashMap<>();
//        kafkaParams.put("metadata.broker.list", "192.168.168.200:9092");
//       //Op.Create direct kafka stream with brokers and topics
//        JavaPairInputDStream<String, String> messages = KafkaUtils.createDirectStream(jssc, String.class, String.class, StringDecoder.class, StringDecoder.class, 45.kafkaParams, topicsSet);
//        // Get the lines, split them into words, count the words and print
//        JavaDStream<String> lines = messages.map(new Function<Tuple2<String, String>, String>() {
//            @Override
//            public String call(Tuple2<String, String> tuple2) {
//                return tuple2._2();
//            }
//        });
//        JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
//            @Override
//            public Iterator<String> call(String line) {
//                return Arrays.asList(line.split(" ")).iterator();
//            }
//        });
//        JavaPairDStream<String, Integer> wordCounts = words.mapToPair(new PairFunction<String, String, Integer>() {
//            @Override
//            public Tuple2<String, Integer> call(String s) {
//                return new Tuple2<>(s, 1);
//            }
//        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
//            @Override
//            public Integer call(Integer i1, Integer i2) {
//                return i1 + i2;
//            }
//        });
//        wordCounts.print();
//        Start the computation
//        jssc.start();
//        jssc.awaitTermination();
        System.out.println("genxin1442");

    }
}