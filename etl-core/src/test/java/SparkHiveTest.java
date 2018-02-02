import org.apache.spark.sql.SparkSession;

import java.io.File;
import java.sql.*;

/**
 * @author yangxin-ryan 
 */
public class SparkHiveTest {
    public static void main(String[] args) throws SQLException {
//        String url="jdbc:hive2://www.hdp02.zgw:2181,www.hdp01.zgw:2181," +
//                "www.hdp03.zgw:2181/;serviceDiscoveryMode=zooKeeper;" +
//                "zooKeeperNamespace=hiveserver2";
//        try {
//            Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        Connection conn = DriverManager.getConnection(url,"hive","");
//        Statement stmt = conn.createStatement();
//        String sql = "sql";
//        ResultSet res = stmt.executeQuery(sql);
//        int dataLength = res.getMetaData().getColumnCount();
//        for(int i=1; i<= dataLength; i++)
//        {
//            System.out.print(res.getMetaData().getColumnName(i));
//            System.out.print("\t");
//        }
//        while(res.next())
//        {
//            for(int i=1; i <= dataLength; i++)
//            {
//                System.out.print(res.getString(i));
//                System.out.print("\t");
//            }
//            System.out.println();
//        }

       // String warehouseLocation = new File("E:\\work2017\\soft\\大数据环境\\spark-2.0.2-bin-hadoop2.6").getAbsolutePath();
//        SparkSession spark = SparkSession
//                .builder()
//                .master("")
//                .config("spark.sql.warehouse.dir", "E:\\work2017\\soft\\大数据环境\\spark-2.0.2-bin-hadoop2.6")
//                .enableHiveSupport()
//                .getOrCreate();

        String warehouseLocation = "/spark-warehouse";
          // init spark session with hive support
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark Hive Example")
                .master("local[*]")
                .config("spark.sql.warehouse.dir", warehouseLocation)
                .enableHiveSupport()
                .getOrCreate();



    }
}


