package com.wintime.read;

import com.wintime.data.SparkSourceFormatType;
import com.wintime.data.SparkDataSource;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SparkTextReadTest {

    @Test
    public void SparkTextRead(){
        String master_url="local";
        String app_name="TextReadTest";
        Map<String,String> config=new HashMap<String, String>();
        Map<String, String> options=new HashMap<String, String>();
        config.put("spark.some.config.option", "some-value");
        options.put("path","C:/Users/Administrator/Desktop/cesi_data/tongji.csv");
        options.put("header","true");
        String format_type= SparkSourceFormatType.FORMAT_CSV;
        SparkRead sparkTextRead =new SparkRead();
        SparkDataSource dataSource=new SparkDataSource(format_type, master_url, app_name,config,options);
        Dataset<Row> df= sparkTextRead.read(dataSource);
        df.show();
    }


}