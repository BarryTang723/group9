package test;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;

import dao.ProvinceDao;
import dao.UserDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import domain.User;
import utils.JDBCUtils;

public class UserDaoTest {
	@Test
	public void haha() {
		User loginUser = new User();
		loginUser.setUsername("twk");
		loginUser.setPwd("twk123");
		
		UserDao dao = new UserDao();
		User retUser = dao.login(loginUser);
		System.out.println(retUser);
	}
	@Test
	public void test2() {
		 ProvinceDao provinceDaoImpl = new ProvinceDaoImpl();
		 List<Province> list = provinceDaoImpl.findAll();
		 System.out.println(list);
	}
}
