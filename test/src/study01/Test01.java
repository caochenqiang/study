package study01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//第二次修改
public class Test01 {
	
	//ceshi
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("数据库驱动加载成功！");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hnbss";
		String password = "hnbss";
		conn = DriverManager.getConnection(url, user, password);
		if(conn != null) {
			System.out.println("oracle数据库连接成功！");
		}
		
		String sql = "select * from B_ORG_INFO";
		Statement stat = conn.createStatement();
		stat.executeQuery(sql);
		ResultSet resultSet = stat.getResultSet();
		while(resultSet.next()) {
			System.out.println(resultSet.getString("ORG_NAME"));
		}
		
		if(resultSet != null) {
			resultSet.close();
		}
		if(stat != null) {
			stat.close();
		}
		if(conn != null) {
			conn.close();
		}
		
		
		
		
	}
}
