package org.juqkai.juqcc.blog.servlet;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;


@Ok("json")
@At("/test")
public class testServlet {
	
	@At("/test")
	public String test(){
		System.out.println("this is test()");
		return "this is test()";
	}
}
