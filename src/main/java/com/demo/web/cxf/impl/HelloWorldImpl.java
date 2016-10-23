package com.demo.web.cxf.impl;

import com.demo.web.cxf.IHelloWorld;

public class HelloWorldImpl implements IHelloWorld {

	@Override
	public String sayHello(String username) {
		System.out.println(username);
		return "Hello " + username;  
	}

	@Override
	public void setUser(String username) {
		// TODO Auto-generated method stub

	}

}
