package com.demo.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		
		factory.setServiceClass(IDAO.class);

		factory.setAddress("http://158727v4y2.51mypc.cn/demo/webservice/helloService?wsdl");

		IDAO client = (IDAO) factory.create();

		String response = client.sayHello("Hai,jiangqiao");

		System.out.println("Response:" + response);
	}

}
