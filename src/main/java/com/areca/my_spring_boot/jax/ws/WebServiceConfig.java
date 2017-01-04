package com.areca.my_spring_boot.jax.ws;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author br2zz@sina.com
 * @version 2017年1月4日 下午4:49:46
 */
@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public EndpointImpl endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new HelloPortImpl());
		endpoint.publish("/Hello");
		return endpoint;
	}

}
