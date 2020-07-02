package proxy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.jsp.jstl.core.Config;

import org.junit.jupiter.api.Test;
//动态代理,filter实现敏感词过滤
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter{

	@Override
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//动态代理
		ServletRequest proxy_req=(ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println(list);
				//增强部分
				if(method.getName().equals("getParameter")) {
					String value = (String) method.invoke(req, args);
					//如果有敏感字符,做替换
					if(value!=null) {
						for (String str : list) {
							if(value.contains(str)) {
								value=value.replaceAll(str, "***");
							}
						}
					}
					return value;
				}
				return method.invoke(req, args);
			}
		});
		chain.doFilter(proxy_req, resp);
	}
	//读文件的内容到list集合里面
	private List<String> list=new ArrayList<String>();
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		try {
			ServletContext servletContext = config.getServletContext();
			String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
			BufferedReader br = new BufferedReader(new FileReader(realPath));
			
			String line=null;
			while((line=br.readLine())!=null) {
				list.add(line);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
