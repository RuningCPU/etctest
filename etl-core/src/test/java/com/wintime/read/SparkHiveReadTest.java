package com.wintime.read;

import com.wintime.data.SparkDataSource;
import com.wintime.data.SparkSourceFormatType;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SparkHiveReadTest {

    @Test
    public void SparkHiveRead(){
        String master_url="local";
        String app_name="HiveReadTest";
        String url="jdbc:hive2://www.hdp02.zgw:2181,www.hdp01.zgw:2181," +
                "www.hdp03.zgw:2181/;serviceDiscoveryMode=zooKeeper;" +
                "zooKeeperNamespace=hiveserver2";
        Map<String,String> config=new HashMap<String, String>();
        Map<String, String> options=new HashMap<String, String>();
        config.put("spark.some.config.option", "some-value");

//        hivedriverClassName=org.apache.hive.jdbc.HiveDriver
//        hiveurl=jdbc:hive2://192.168.31.243:10000/default
//        hiveusername=root
//        hivepassword=
        options.put( "driver","org.postgresql.Driver");
        options.put("url", url);
        options.put("user", "hive");
        options.put("password","");
        options.put("dbtable", "zhzs_gsj_sbmx");
        String format_type= SparkSourceFormatType.FORMAT_JDBC;
        SparkRead sparkTextRead =new SparkRead();
        SparkDataSource dataSource=new SparkDataSource(format_type, master_url, app_name,config,options);
        Dataset<Row> df= sparkTextRead.read(dataSource);
        df.show();
    }
}