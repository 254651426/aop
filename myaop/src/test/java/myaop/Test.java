package myaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yangjie.Service.Ihelloworld;
import com.yangjie.ServiceImpl.HelloworldImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-*.xml");
//		context.start();
		Ihelloworld user = (Ihelloworld) context.getBean(Ihelloworld.class);
		String ss = user.helloword();
		 
	}

}
