package com.areca.my_spring_boot.jax.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *  http://localhost:666/services/Hello?wsdl
* @author br2zz@sina.com
* @version 2017年1月4日 下午4:47:45
*/
@WebService(name = "Hello")
public interface Hello {
	
	@WebResult()
    @WebMethod()
    String sayHello(@WebParam(name = "myname") String myname);
	
}
