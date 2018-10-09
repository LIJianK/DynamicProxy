package com.pro.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyDynamicProxy implements InvocationHandler {

	private UserService userService;
	public MyDynamicProxy(UserService userService){
		this.userService = userService;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("--进入--");
		
		Object result = method.invoke(userService, args);
		
		System.out.println("--出来--");
		
		return result;
	}

}
