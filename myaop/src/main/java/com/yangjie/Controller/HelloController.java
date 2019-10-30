package com.yangjie.Controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yangjie.Service.Ihelloworld;

@RestController
public class HelloController {

	@Autowired
	private Ihelloworld helloworldImpl;

	@RequestMapping(value = "/showtime", method = RequestMethod.GET)
	public HashMap<String, Object> showtime() {
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("nihao", helloworldImpl.helloword());
		return m;
	}

	@RequestMapping(value = "/cookietest", method = RequestMethod.GET)
	public void cookietest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			out.write("您上次的访问时间是：");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("lastAccessTime")) {
					Long lastAccessTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					out.write(date.toLocaleString());
				}
			}
		} else {
			out.write("这是您第一次访问本站！");
		}
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		response.addCookie(cookie);
	}

}
