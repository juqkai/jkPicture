package org.juqkai.juqcc;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.juqkai.juqcc.dao.PhotoDao;
import org.juqkai.juqcc.domain.Page;
import org.juqkai.juqcc.domain.Photo;

@SuppressWarnings("serial")
public class JuqccListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Long pa = 1l;
		if(req.getParameter("pg") != null){
			pa = Long.parseLong(req.getParameter("pg"));
		}
		Page page = new Page();
		page.setCurrentPage(pa);
		
		PhotoDao pdao = PhotoDao.getInstance();
		List<Photo> photos = pdao.listAll(page);
		req.setAttribute("photos", photos);
		req.setAttribute("pg", page);
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
