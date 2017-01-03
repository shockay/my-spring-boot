package com.areca.my_spring_boot.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName="myFilter", urlPatterns="/*")
public class MyFilter implements Filter {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void destroy() {
		log.info("MyFilter.destroy()...");		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		 log.info("MyFilter.doFilter()...");
	     arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("MyFilter.init()...");
	}

}
