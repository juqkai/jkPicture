package org.juqkai.juqcc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import com.google.appengine.api.datastore.Blob;

@SuppressWarnings("serial")
public class JuqccUploadServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			uploadPhoto(req);
//			req.setAttribute("Pid", uploadPhoto(new ServletFileUpload().getItemIterator(req)));
			req.getRequestDispatcher("photo.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
	
	private void uploadPhoto(HttpServletRequest req) throws FileUploadException, IOException{
		FileItemIterator iterator = new ServletFileUpload().getItemIterator(req);
		while (iterator.hasNext()) {
			FileItemStream item = iterator.next();
			Blob bImg = new Blob(IOUtils.toByteArray(item.openStream()));
			Photo photo = new Photo();
			photo.setPhoto(bImg);
			photo.setName(parseName(item.getFieldName()));
			PhotoDao.getInstance().insertPhoto(photo);
		}
	}

	private String parseName(String filePath) {
		String fp = filePath.replaceAll("/", "\\");
		return fp.substring(fp.lastIndexOf("\\"));
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
