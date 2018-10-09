package com.pro.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Dynamic();
		
		Enhancer eh = new Enhancer();
		eh.setSuperclass(UserServiceImpl.class);
		eh.setCallback(new MyCgProxy());
		
		UserService userService = (UserService) eh.create();
		
		userService.addUser("16:44");
		userService.updateUser("16:45");
		
	}

	private static void Dynamic() {
		UserService userService = new UserServiceImpl();
		InvocationHandler ih = new MyDynamicProxy(userService);
		
		UserService userServicePI = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), ih);
		userServicePI.addUser("16:38");
		userServicePI.updateUser("16:39");
	}

}
