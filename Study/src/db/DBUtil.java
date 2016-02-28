package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

	private final static String CONNECTION_DRIVER_STR;
	private final static String CONNECTION_URL_STR;
	private final static String DB_USERNAME;
	private final static String DB_PWD;
	
	static{
		PropertiesUtil.loadFile("dbconfig.properties");
		CONNECTION_DRIVER_STR = PropertiesUtil.getProperityValue("driverName");
		CONNECTION_URL_STR = PropertiesUtil.getProperityValue("url");
		DB_USERNAME = PropertiesUtil.getProperityValue("user");
		DB_PWD = PropertiesUtil.getProperityValue("password");
		
	}
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName(CONNECTION_DRIVER_STR);
			conn = DriverManager.getConnection(CONNECTION_URL_STR,DB_USERNAME,DB_PWD);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @param st
	 * @param rss
	 */
	public static void closeConnection(Connection conn,Statement st,ResultSet rss){
		try{
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
			conn = null;
		}
		try{
			if(st != null){
				st.close();
			}
		}catch(Exception e){
			st = null;
		}
		try{
			if(rss != null){
				rss.close();
			}
		}catch(Exception e){
			rss = null;
		}
	}
	
}
