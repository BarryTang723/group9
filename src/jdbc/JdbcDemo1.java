package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8","root","admin");
		String sql="insert into account values(null,'уехЩ',20) ";
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		System.out.println(count);
		stmt.close();
		conn.close();
	}
}
