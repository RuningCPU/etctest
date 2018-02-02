package com.wintime.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class SparkDataSource {
    //指定数据源文件的格式类型，默认CSV
    private String format_type= SparkSourceFormatType.FORMAT_CSV;
    /*
      local 本地单线程
      local[K] 本地多线程（指定K个内核）local[*]
      本地多线程（指定所有可用内核）spark://HOST:PORT  连接到指定的 Spark standalone cluster master，需要指定端口。
      mesos://HOST:PORT  连接到指定的  Mesos 集群，需要指定端口。
      yarn-client客户端模式 连接到 YARN 集群。需要配置 HADOOP_CONF_DIR。
      yarn-cluster集群模式 连接到 YARN 集群
      。需要配置 HADOOP_CONF_DIR。
    */
    private String master_url;
    //应用程序名字
    private String app_name;
    //spark 的config设置
    private Map<String,String> config ;
    //文本选项
    private  Map<String, String> options;
    SparkDataSource(String format_type, String master_url, String app_name){
        this( format_type, master_url, app_name,null,null);
    }
}