package org.juqkai.juqcc.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class PhotoUtil {
	private static String ONE_PHOTO_URL = "/jquccOne?id=";
	/**
	 * 生成图片的URL地址
	 * @param req
	 * @return
	 */
	public static String getPhotoUrl(HttpServletRequest req){
		File fi = new File(req.getRequestURL().toString());
		String path = "";
		path += fi.getParentFile().getParent();
		path = path.replace("\\", "//");
		path += ONE_PHOTO_URL;
		return path;
	}
	
	public static Boolean login(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		if(user == null){
			resp.sendRedirect(us.createLoginURL(req.getRequestURI()));
			return false;
		}
		if(!us.isUserAdmin()){
			try {
				req.setAttribute("message", "你没有权限!");
				req.getRequestDispatcher("/juqccList").forward(req, resp);
			} catch (ServletException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return true;
	}
}
