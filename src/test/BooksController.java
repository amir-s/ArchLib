package test;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import javazoom.upload.*;





public class BooksController {
	public String index(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException{
		return "Home.jsp";
	}
	
	public String add(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException{
		request.setAttribute("Authors", AuthorRepo.getRepo().getAll());
		request.setAttribute("title", "Add a Book");
		return "addBook.jsp";
	}
	
	public String insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException, UploadException{
		MultipartFormDataRequest request = new MultipartFormDataRequest(req);
		
		if (request.getParameter("book_title") == null || request.getParameter("book_isbn") == null || request.getParameter("book_year") == null || request.getParameter("book_publisher") == null || request.getParameter("author_id") == null) {
			req.setAttribute("error", true);
			return add(req, resp);
		}
		

		
		
		Book book = new Book();
		book.setTitle(request.getParameter("book_title"));
		book.setIsbn(request.getParameter("book_isbn"));
		book.setYear(Integer.parseInt(request.getParameter("book_year")));
		book.setPublisher(request.getParameter("book_publisher"));
		book.setAuthor_id(Integer.parseInt(request.getParameter("author_id")));
		
		
		UploadBean upb = new UploadBean();
		String fileName = ((UploadFile)(request.getFiles().get("pdf_file"))).getFileName();
		upb.setFolderstore("/home/amir/books/" + book.getIsbn() + "/");
		upb.store(request, "pdf_file");
		
		book.setFileName(fileName);
		
		BookRepo.getRepo().insert(book);
		
		
		req.setAttribute("added", true);
		
		return add(req, resp);
	}
	

}