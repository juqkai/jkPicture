package org.juqkai.juqcc.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class PhotoUtil {
	private static String ONE_PHOTO_URL = "/jquccOne?id=";
	public static String getPhotoUrl(HttpServletRequest req){
		File fi = new File(req.getRequestURL().toString());
		String path = "";
		path += fi.getParentFile().getParent();
		path = path.replace("\\", "//");
		path += ONE_PHOTO_URL;
		return path;
	}
}
