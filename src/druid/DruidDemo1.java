package druid;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import utils.JDBCUtils;

import java.util.*;

import javax.sql.DataSource;



public class DruidDemo1 {
	public static void main(String[] args) throws Exception{
//		Properties pro = new Properties();
//		InputStream is = DruidDemo1.class.getResourceAsStream("druid.properties");
//		pro.load(is);
//		System.out.println(is);
//		DataSource ds = DruidDataSourceFactory.createDataSource(pro);
//		
//		Connection conn = ds.getConnection();
//		System.out.println(conn);
		
		String username="twk";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = JDBCUtils.getConnection();
			String sql="select pwd from webaccount where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				String pwd=rs.getString("pwd");
				System.out.println(pwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(pstmt, conn);
		}
	}
}
