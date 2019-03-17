package com.example.demo.servletComponent;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;

@WebFilter(filterName="ayUserFilter",urlPatterns="/*")
public class AyUserFilter implements Filter{

	private org.apache.logging.log4j.Logger logger=LogManager.getLogger(this.getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("-------------->> initiate.....");
		logger.info("-------------->> logger initiate.....");
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("---------------->>>>> do ayUserFilter");
		
		chain.doFilter(request, response);
		
	}
	
	
	@Override
	public void destroy() {
		System.out.println("---------------->>>>> been destroyed!");
	}

}
