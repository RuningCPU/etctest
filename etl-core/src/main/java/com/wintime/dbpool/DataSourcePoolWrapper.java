package com.wintime.dbpool;


import com.wintime.data.JdbcDataSource;

import javax.sql.DataSource;

/**
 * 数据源连接包装器
 *
 * @author tomdeng
 */
public interface DataSourcePoolWrapper {
    DataSource wrap(JdbcDataSource rptDs);
}
