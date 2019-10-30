package com.yangjie.ServiceImpl;

import org.springframework.stereotype.Service;

import com.yangjie.Service.Ihelloworld;

@Service
public class HelloworldImpl implements Ihelloworld {

	@Override
	public String helloword() {
		// TODO Auto-generated method stub
		System.out.println("我在吃饭");
		return "nihao hellow world";
	}

}
