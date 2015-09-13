package net.itaem.tool;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *链接数据库的工具类
 * @authorzhetang
 *
 */

public class DataBaseConnection {
	private Connection conn = null ;
	public DataBaseConnection(){
		InputStream ins = getClass().getResourceAsStream("/db.properties") ;
		Properties dbProp = new Properties() ;
		try {
			dbProp.load(ins);
			String driver = dbProp.getProperty("db.driver").trim();
			String url = dbProp.getProperty("db.url").trim();
			String user = dbProp.getProperty("db.user").trim() ;
			String password = dbProp.getProperty("db.password").trim();
			Class.forName(driver).newInstance() ;
			this.conn = DriverManager.getConnection(url,user,password) ;
			this.conn.setAutoCommit(true) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return this.conn ;
	}
	
	public void close(){
		
	}
}
