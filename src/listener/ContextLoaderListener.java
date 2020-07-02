package listener;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ContextLoaderListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		ServletContext servletContext = servletContextEvent.getServletContext();
		String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
		String realPath = servletContext.getRealPath(contextConfigLocation);
		System.out.println("contextConfigLocation:"+contextConfigLocation);
		System.out.println("realpath:"+realPath);
		try {
			FileInputStream fis = new FileInputStream(realPath);
			System.out.println(fis);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("ServletContext对象呗创建了...");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext被销毁了....");
	}
	
}
