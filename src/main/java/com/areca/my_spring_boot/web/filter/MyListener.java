package com.areca.my_spring_boot.web.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.areca.my_spring_boot.config.MyConfig;

@WebListener
public class MyListener implements ServletContextListener {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	 MyConfig config;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("MyListener.contextDestroyed()...");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 log.info("MyListener.contextInitialized()...");
		 arg0.getServletContext().setAttribute("config", config);
	}

}
