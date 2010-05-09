package nutz.demo.mvc.helloworld;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.meta.Email;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.annotation.Attr;

/**
 * 这是一个非常简单的模块，它甚至都没有用到注入。
 * <p>
 * 通过访问： http://localhost:8080/hellomvc/helloworld.jsp 快速查看本演示
 * <p>
 * 通过这个例子我只是想 告诉大家， Nutz.Mvc 可以让你的代码变得有多简洁
 * <p>
 * 你还可以在模块类上声明：
 * <ul>
 * <li>'@At' 整个模块的 URL 的前缀，如果不声明，则如前缀。如果不声明值，对于本模块，为 /helloworld
 * <li>'@Ok' 整个模块默认的，顺利执行完操作后的渲染视图
 * <li>'@Fail' 整个模块默认的，执行操作期间发生 Exception 的渲染视图
 * <li>'@AdaptBy' 这个模块默认的，处理 HTTP 请求的方式。 如不声明,则用整个应用的默认值。
 * 如果应用没有设置这个注解，则采用普通名值对的方式处理请求。 细节，请参看 org.nutz.mvc.param.PairHttpAdaptor 的说明
 * </ul>
 * 如果你想让 Nutz.Ioc 来让你的模块类拥有更灵活的结构，请用注解 '@InjectName' 来声明当前模块的 Ioc 注入名。
 * 当然，前提是，你必须在你的应用配置类上（你声明在 web.xml 的那个类）注明 '@IocBy'。 以便框架知道如何为你生成 Ioc 接口的实现
 * <p>
 * 我假设你是了解 Nutz.Ioc 的，如果不了解，并且想用注入的办法组织的你应用程序，请起码先从 Demo 项目中找找 HelloIoc 来看看
 * <p>
 * 本模块类的 '@Ok' 注解说明了某模块所有函数执行成功后默认的渲染方式，如果模块内的入口函数没有声明自己的 @Ok， 那么将使用 Json
 * 的方式默认进行渲染
 * <p>
 * <p>
 * 延伸阅读，建议大家阅读一下 org.nutz.mvc.ViewMaker 的 JDoc， 上面写的很清楚。 尤其是告诉你如何自己动手
 * 支持其他的模板引擎。总的来说，就是实现两个接口，以及在自己的应用上增加一项配置
 * 
 * @author zozoh
 */
@Ok("json")
public class HelloWorld {

	/**
	 * 任何一个函数都可以作为入口函数。只要它是 public 并且声明了 @At 注解，那么就会被框架 当做入 口函数 当前的函数将自动和路径
	 * "/全小写函数名" 挂接。
	 * <p>
	 * 当然，如果你在整个模块类上也声明了 '@At' 注解，那么显然你当前的函数挂接的 URL 就得和模块的 Url 合并了。
	 * <p>
	 * <i>网址示意： http://localhost:8080/hellomvc/say.nut</i>
	 */
	@At
	public String say() {
		return "Hello world";
	}

}
