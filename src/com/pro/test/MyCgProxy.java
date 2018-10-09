package com.pro.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyCgProxy implements MethodInterceptor {

	public Object intercept(Object object, Method method, Object[] objects,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("--进入--");
		
		Object result = methodProxy.invokeSuper(object, objects);
		
		System.out.println("--离开--");
		
		return result;
	}

}
