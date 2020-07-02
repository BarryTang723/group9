package test;

import java.io.File;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Person;

public class JacksonTest {
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		p.setName("wangxiaojing");
		p.setAge(23);
		p.setGender("nv");
		p.setBirthday(new Date());
		
		ObjectMapper mapper= new ObjectMapper();
		String json = mapper.writeValueAsString(p);
		System.out.println(json);
		
//		mapper.writeValue(new File("d://a.txt"), p);
	}
}
