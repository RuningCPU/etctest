package com.wintime.data;

public class SparkSourceFormatType {
    //csv，parquet，json,text
    public static final String FORMAT_CSV="org.apache.spark.sql.execution.datasources.csv.CSVFileFormat";
    public static final String FORMAT_PARQUET="org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat";
    public static final String FORMAT_JSON="org.apache.spark.sql.execution.datasources.json.JsonFileFormat";
    public static final String FORMAT_TEXT="org.apache.spark.sql.execution.datasources.text.TextFileFormat";
    public static final String FORMAT_JDBC="jdbc";
}