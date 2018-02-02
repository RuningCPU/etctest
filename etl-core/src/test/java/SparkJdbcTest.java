import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

import java.util.HashMap;
import java.util.Map;

public class SparkJdbcTest {
    public static void main(String[] args) {

        SparkConf sparkConf = new SparkConf().setAppName("JavaSparkSQL").setMaster("local[1]");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);
        SQLContext sqlContext = new SQLContext(jsc);
        Map<String, String> options = new HashMap<String, String>();
        options.put("url", "jdbc:oracle:thin:@192.168.1.165:1521/orcl");
        options.put("user", "BYZHZS");
        options.put("password","BYZHZS");
        //读取test表10.
        options.put("dbtable", "test");
        Dataset<Row> df = sqlContext.read().format("jdbc").options(options).load();
        df.show();


    }
}