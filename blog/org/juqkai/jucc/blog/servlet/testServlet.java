package org.juqkai.jucc.blog.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testServlet {
	
	@RequestMapping("/test/test.htm")
	public void test(){
		System.out.println("this is test()");
	}
}
