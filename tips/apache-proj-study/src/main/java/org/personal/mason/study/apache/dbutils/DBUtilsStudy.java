package org.personal.mason.study.apache.dbutils;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class DBUtilsStudy {

public final DataSource dataSource;

public DBUtilsStudy(){
	this.dataSource = new MysqlConnectionPoolDataSource();
	
}

}
