package com.wintime.read;

import com.wintime.data.SparkDataSource;
import com.wintime.data.SparkSourceFormatType;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SparkJdbcReadTest {
    @Test
    public void SparkJdbcRead(){
        String master_url="local";
        String app_name="JdbcReadTest";
        Map<String,String> config=new HashMap<String, String>();
        Map<String, String> options=new HashMap<String, String>();
        config.put("spark.some.config.option", "some-value");
        options.put("url", "jdbc:oracle:thin:@192.168.1.165:1521/orcl");
        options.put("user", "BYZHZS");
        options.put("password","BYZHZS");
        options.put("dbtable", "bm_aaa003");
        String format_type= SparkSourceFormatType.FORMAT_JDBC;
        SparkRead sparkTextRead =new SparkRead();
        SparkDataSource dataSource=new SparkDataSource(format_type, master_url, app_name,config,options);
        Dataset<Row> df= sparkTextRead.read(dataSource);
        df.show();
    }
}