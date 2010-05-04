package org.juqkai.juqcc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesServiceFactory;

@SuppressWarnings("serial")
public class JuqccServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		PhotoDao pdao = PhotoDao.getInstance();
		
		List<Photo> photos = pdao.listAll();
		req.setAttribute("photos", photos);
		try {
			req.getRequestDispatcher("/photo/photoList.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
