package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost...");
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		if (username.equals("twk")&&pwd.equals("twk123")) {
			System.out.println("你就是那个人!!");
			resp.setStatus(302);
			resp.setHeader("location","https://www.bilibili.com/" );
		}
		System.out.println(username);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
