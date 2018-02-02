

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;

public class sparkCsvTest {

    public static void main(String[] args) {
        String filePath = "C:/Users/Administrator/Desktop/cesi_data/SogouTDTE.txt";
//        SparkConf conf = new SparkConf();
//        conf.set("spark.testing.memory", "2147480000"); // 因为jvm无法获得足够的资源
//        JavaSparkContext sc = new JavaSparkContext("local", "cvs read spark", conf);
//        JavaRDD<String> ssc=sc.textFile(filePath);
        SparkSession spark = SparkSession
                .builder()
                .master("local[2]")
                .appName("Java Spark SQL basic example")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();
//       Dataset<Row> df = spark.read().csv(filePath);
//        df.show();
//        // Print the schema in a tree format
//        df.printSchema();

       // SQLContext sqlContext = new SQLContext(spark);
//        1、path：看名字就知道，这个就是我们需要解析的CSV文件的路径，路径支持通配符；
//        2、header：默认值是false。我们知道，CSV文件第一行一般是解释各个列的含义的名称，如果我们不需要加载这一行，我们可以将这个选项设置为true；
//        3、delimiter：默认情况下，CSV是使用英文逗号分隔的，如果不是这个分隔，我们就可以设置这个选项。
//        4、quote：默认情况下的引号是'"'，我们可以通过设置这个选项来支持别的引号。
//        5、mode：解析的模式。默认值是PERMISSIVE，支持的选项有
//        　　（1）、PERMISSIVE：尝试解析所有的行，nulls are inserted for missing tokens and extra tokens are ignored.
//        　　（2）、DROPMALFORMED：drops lines which have fewer or more tokens than expected
//        　　（3）、FAILFAST: aborts with a RuntimeException if encounters any malformed line
        Dataset<Row> df = spark.read().option("header","true").option("path",filePath).format("org.apache.spark.sql.execution.datasources.csv.CSVFileFormat").load();
        df.show();
        // mapRDD(ssc);
    }


    // mapRDD 对每一条输入进行指定的操作，然后为每一条输入返回一个对象
    public static void mapRDD(JavaRDD<String> listRDD) {
        JavaRDD<String[]> strMapRDD = listRDD.map(new Function<String, String[]>() {
            @Override
            public String[] call(String v1) throws Exception {
                // TODO Auto-generated method stub
                return v1.split(" ");
            }
        });
        System.out.println(printAList(strMapRDD.collect()));
    }

    // 打印list
    public static String printAList(List<String[]> list) {
        System.out.println();
        String str = "map result=  \n";
        for (int i = 0; i < list.size(); i++) {
            String[] listAray = list.get(i);
            for (int j = 0; j < listAray.length; j++) {
                if (j == 0) {
                    str += "[" + listAray[j] + ",";
                } else if (j == listAray.length - 1) {
                    str += "," + listAray[j] + "]\n";
                } else {
                    str += "," + listAray[j];
                }
            }
        }
        return str;
    }
}