package com.springbatch.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by ksy on 2015/7/27.
 */
@Component
public class DataSourceConfiguration {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataSourceConfiguration(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public DataSource createNewDataSource(String driverName, String url, String userName, String password, int type){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        if(driverName == null || driverName.equals("")){
            switch (type){
                case 0:dataSource.setDriverClassName(DBDrivers.getDriver(DBDrivers.MYSQL));
                case 1:dataSource.setDriverClassName(DBDrivers.getDriver(DBDrivers.ORACLE));
                case 2:dataSource.setDriverClassName(DBDrivers.getDriver(DBDrivers.SQLSERVER));
            }
        }else{
            dataSource.setDriverClassName(driverName);
        }

        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    public enum DBDrivers {
        MYSQL, ORACLE, SQLSERVER;

        public static String getDriver(DBDrivers drivers){
            switch (drivers){
                case MYSQL:return "com.mysql.jdbc.Driver";
                case ORACLE:return "oracle.jdbc.driver.OracleDriver";
                case SQLSERVER:return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                default:return "com.mysql.jdbc.Driver";
            }
        }
    }
}
