package org.juqkai.juqcc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.juqkai.juqcc.util.PhotoUtil;

@SuppressWarnings("serial")
public class JuqccPreUploadServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if(!PhotoUtil.login(req, resp)){
			return ;
		}
		
		try {
			req.getRequestDispatcher("/photo/photoList.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
