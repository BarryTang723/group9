package servletContext;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = this.getServletContext();
		String filename="/img/1.png";
		String realPath = context.getRealPath("/");
		URL url = context.getResource("1.png");
//		String path = this.getClass().getClassLoader().getResource("/").getPath();
//		String path2=this.getClass().getResource("/1.png").getPath();
		String path3=this.getClass().getResource("/").getPath().replaceAll("^(/)|(/WEB-INF/classes/)$", "");
		// C:\\Users\\WDTMD\\workspaceJavaWeb\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Servlet\\img\\1.png
		System.out.println(realPath+"img\\1.png");
//		System.out.println("2:"+realPath2);
		System.out.println(url);
	}
}
