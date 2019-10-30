package com.yangjie.cglib;

import com.yangjie.ServiceImpl.HelloworldImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CglibProxyExample cpe = new CglibProxyExample();
		System.out.println(cpe.getClass());
		HelloworldImpl proxy = (HelloworldImpl) cpe.getProxy(HelloworldImpl.class);
		proxy.helloword();
		System.out.println(proxy.getClass());
	}

}
