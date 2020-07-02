package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.User;
import utils.JDBCUtils;

public class UserDao {
	
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	public User login(User loginUser) {
		try {
			String sql="select * from webaccount where username=? and pwd=? ";
			User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
					loginUser.getUsername(),loginUser.getPwd());
			
			return user;
		} catch (Exception e) {
			return null;
		}
	}
}
