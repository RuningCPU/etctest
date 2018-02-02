package com.wintime.dbpool;

/**
 * 数据源连接池工厂
 *
 * @author tomdeng
 */
public class DataSourcePoolFactory {
    public static DataSourcePoolWrapper create(final String className) {
        try {
            return (DataSourcePoolWrapper)Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("DataSourcePoolFactory Load Class Error", e);
        }
    }
}
