package org.juqkai.juqcc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.juqkai.juqcc.dao.PhotoDao;
import org.juqkai.juqcc.domain.Photo;

@SuppressWarnings("serial")
public class JuqccServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
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
