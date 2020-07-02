package dao.impl;

import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.ProvinceDao;
import domain.Province;
import utils.JDBCUtils;


public class ProvinceDaoImpl implements ProvinceDao{
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	@Override
	public List<Province> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from province";
		List<Province> list = template.query(sql,new BeanPropertyRowMapper<Province>(Province.class));
		return list;
	}
	
	
}
