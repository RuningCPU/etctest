package com.wintime.read;

import com.wintime.data.DataSource;
import com.wintime.data.TextDataSource;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Map;


public class SparkTextReadable implements Readable {
    @Override
    public Dataset<Row> read(DataSource dataSource) {
        TextDataSource textDataSource=(TextDataSource)dataSource;
        SparkSession sparkSession=textDataSource.getDataSource();
        String format_type=textDataSource.getFormat_type();
        String file_path= textDataSource.getFile_Path();
        Map<String, String> options= textDataSource.getOptions();
        for (String key : options.keySet()) {
            sparkSession.conf().set(key,options.get(key));
        }
        return sparkSession.read().format(format_type).load(file_path);
    }
}