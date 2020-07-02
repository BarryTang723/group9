package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import dao.UserDao;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String username=req.getParameter("username");
		String pwd = req.getParameter("pwd");
		User loginUser = new User();
		//≤‚ ‘
		loginUser.setUsername(username);
		loginUser.setPwd(pwd);
//		System.out.println(loginUser);
		UserDao dao = new UserDao();
		User user = dao.login(loginUser);		
		System.out.println(user);//User [id=0, username=twk, pwd=twk123]
		//≤‚ ‘¥˙¬Î
//		User user = new User();
//		user.setUsername("twk");
//		user.setPwd("twk123");
		if(user==null) {
			req.getRequestDispatcher("/failLogin").forward(req, resp);
			
		}else {
			req.setAttribute("user", user);
			req.getRequestDispatcher("/successLogin").forward(req, resp);
		}
//		System.out.println(loginUser);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
