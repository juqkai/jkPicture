package org.juqkai.jucc.blog.nutz;

import org.juqkai.juqcc.blog.servlet.ArticleServlet;
import org.juqkai.juqcc.blog.servlet.testServlet;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Modules;

@Modules({
	testServlet.class,
	ArticleServlet.class
})
@Fail("json")
public class MainModule {
	public MainModule(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
