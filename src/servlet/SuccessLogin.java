package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

/**
 * Servlet implementation class SuccessLogin
 */
@WebServlet("/successLogin")
public class SuccessLogin extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("successlogin被访问了!");
		
		User user = (User)request.getAttribute("user");

		if(user!=null) {
//			response.getWriter().write("hehhehehe");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("登录成功!你好"+user.getUsername());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
