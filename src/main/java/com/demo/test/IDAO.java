package com.demo.test;

import javax.jws.WebMethod;
import javax.jws.WebService; 
import javax.jws.WebParam;  

@WebService
public interface IDAO {
	@WebMethod  
	public String sayHello(@WebParam(name = "username") String username);

}
