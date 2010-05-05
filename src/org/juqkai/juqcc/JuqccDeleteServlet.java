package org.juqkai.juqcc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.juqkai.juqcc.dao.PhotoDao;
import org.juqkai.juqcc.domain.Page;
import org.juqkai.juqcc.domain.Photo;

@SuppressWarnings("serial")
public class JuqccDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Long pa = 1l;
		if (req.getParameter("page") != null) {
			pa = Long.parseLong(req.getParameter("page"));
		}
		Page page = new Page();
		page.setCurrentPage(pa);

		PhotoDao pdao = PhotoDao.getInstance();
		
		Long id = Long.parseLong(req.getParameter("id"));
		Photo photo = new Photo();
		photo.setId(id);
		pdao.deletePhoto(photo);
		
		
		
		try {
			req.getRequestDispatcher("/juqccList").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
