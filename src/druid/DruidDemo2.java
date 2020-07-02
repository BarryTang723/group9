package druid;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import utils.JDBCUtils;

import java.util.*;

import javax.sql.DataSource;

public class DruidDemo2 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = JDBCUtils.getConnection();
			String sql="insert into account values(null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "ÌÆÎ¬¿µ");
			pstmt.setDouble(2, 12000);
			int count = pstmt.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(pstmt, conn);
		}
		
	}
}
