package com.wintime.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class JdbcDataSource {
    //获取数据源唯一标识
    @Getter
    private final String uid;
//    //具体Queryer类完全名称
//    @Getter
//    private final String queryerClass;
    //具体DataSourcePoolWrapper类完全名称
    @Getter
    private final String dbPoolClass;
    //数据源驱动类
    @Getter
    private final String driverClass;
    //数据源连接字符串(JDBC)
    @Getter
    private final String jdbcUrl;
    //数据源登录用户名
    @Getter
    private final String user;
    //数据源登录密码
    @Getter
    private final String password;
    //数据源配置选项,如果没有配置选项则设置为默认选项
    @Getter
    private final Map<String, Object> options;

    public JdbcDataSource(final String uid, final String driverClass, final String jdbcUrl, final String user,
                          final String password,
                           final String dbPoolClass) {
        this(uid, driverClass, jdbcUrl, user, password, dbPoolClass, new HashMap(3));
    }
}
