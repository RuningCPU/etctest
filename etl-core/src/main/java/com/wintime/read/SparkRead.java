package com.wintime.read;

import com.wintime.data.SparkDataSource;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Map;


public class SparkRead implements Readable {

    @Override
    public Dataset<Row> read(Object object) {
        SparkDataSource sparkDataSource =(SparkDataSource)object;
        SparkConf conf = new SparkConf().setAppName(sparkDataSource.getApp_name()).setMaster(sparkDataSource.getMaster_url());
        if(sparkDataSource.getConfig()!=null){
            for (String key : sparkDataSource.getConfig().keySet()) {
                conf.set(key, sparkDataSource.getConfig().get(key));
            }
        }
        SparkSession sparkSession=SparkSession.builder().config(conf).getOrCreate();
        String format_type= sparkDataSource.getFormat_type();
        Map<String, String> options= sparkDataSource.getOptions();
        return sparkSession.read().format(format_type).options(options).load();
    }

}