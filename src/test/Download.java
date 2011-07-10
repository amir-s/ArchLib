package test;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Download() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") == null) {
			response.getOutputStream().println("Access Denied! :D");
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		try {
			Book book = BookRepo.getRepo().getByID(id);
			File file = new File("/home/amir/books/" + book.getIsbn() + "/" + book.getFileName());
			stream = response.getOutputStream();
			response.setContentType("application/pdf");

			response.addHeader("Content-Disposition", "attachment; filename="+ book.getFileName());
			response.setContentLength((int) file.length());
			FileInputStream input = new FileInputStream(file);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			while ((readBytes = buf.read()) != -1) stream.write(readBytes);
		} catch (IOException ioe) {
			throw new ServletException(ioe.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stream != null)
				stream.close();
			if (buf != null)
				buf.close();
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
