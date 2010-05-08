package org.juqkai.juqcc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.juqkai.juqcc.dao.PhotoDao;
import org.juqkai.juqcc.domain.Photo;

@SuppressWarnings("serial")
public class JuqccOneServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		PhotoDao pdao = PhotoDao.getInstance();
		
		Long id = Long.parseLong(req.getParameter("id"));
		Photo ph = new Photo();
		ph.setId(id);
		
		resp.setCharacterEncoding("utf-8");
		Photo photo = pdao.findById(ph);
		resp.setContentType("image/jpeg;charset=utf-8");
		resp.getOutputStream().write(photo.getPhoto().getBytes());
		resp.getOutputStream().close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
