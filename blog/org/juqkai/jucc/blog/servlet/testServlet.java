package org.juqkai.jucc.blog.servlet;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testServlet {
	
	@RequestMapping("/test/test.htm")
	public void test(){
		System.out.println("this is test()");
	}
}
