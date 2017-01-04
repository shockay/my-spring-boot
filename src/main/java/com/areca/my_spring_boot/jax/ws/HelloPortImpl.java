package com.areca.my_spring_boot.jax.ws;

import javax.jws.WebService;

/**
* @author br2zz@sina.com
* @version 2017年1月4日 下午4:48:55
*/
@WebService
public class HelloPortImpl implements Hello {

	@Override
	public String sayHello(String myname) {
		return "Hello, Welcome to CXF Spring boot " + myname + "!!!";
	}

}
