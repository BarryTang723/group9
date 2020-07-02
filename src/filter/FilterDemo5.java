package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//@WebFilter(value = "/*",dispatcherTypes = { DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo5 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		System.out.println("filter demo5 ±ª÷¥––¡À ");
		chain.doFilter(request, response);
	}
	

}
