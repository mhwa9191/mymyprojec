package micky.sports.shop.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	static Connection conn;
	
	public static Connection getConnection() {
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="micky";
			String pw="123456";
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pw);
			
			System.out.println("/*/* conn신호");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
