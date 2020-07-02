package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		response.setContentType("text/html;charset=utf-8");
		Map<String, Object> map=new HashMap<String, Object>();
		if("tom".equals(username)) {
			map.put("userExist", true);
			map.put("msg","用户名重复!");
		}else {
			map.put("userExist", false);
			map.put("msg","用户名可用.");
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), map);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
