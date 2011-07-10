package test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

public class AuthorsController {

	public String add(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException{
		request.setAttribute("Authors",AuthorRepo.getRepo().getAll());
		request.setAttribute("title", "Add an Author");
		return "addAuthor.jsp";
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException{
		if (request.getParameter("author_email") == null || request.getParameter("author_name") == null || request.getParameter("author_website") == null) {
			request.setAttribute("error", true);
			return add(request, resp);
		}
		Author auth =  new Author();
		auth.setEmail(request.getParameter("author_email"));
		auth.setName(request.getParameter("author_name"));
		auth.setWebsite(request.getParameter("author_website"));
		
		AuthorRepo.getRepo().insert(auth);
		request.setAttribute("added", true);
		
		return add(request, resp);
	}
	
	public String edit(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException{
		if (request.getParameter("id") == null) {
			request.setAttribute("error", true);
			return add(request, resp);
		}
		Author auth = AuthorRepo.getRepo().getByID(Integer.parseInt(request.getParameter("id")));
		if (auth == null) {
			request.setAttribute("notFound", true);
			return add(request, resp);
		}
		request.setAttribute("Author", auth);
		request.setAttribute("title", "Edit an Author");
		return "editAuthor.jsp";
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException{
		if (request.getParameter("id") == null) {
			request.setAttribute("error", true);
			return add(request, resp);
		}
		AuthorRepo.getRepo().deleteByID(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("title", "Edit an Author");
		request.setAttribute("deleted", true);
		request.setAttribute("Authors",AuthorRepo.getRepo().getAll());
		return add(request, resp);
	}
	
	public String update (HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException{
		if (request.getParameter("author_id") == null || request.getParameter("author_email") == null || request.getParameter("author_name") == null || request.getParameter("author_website") == null) {
			request.setAttribute("error", true);
			return add(request, resp);
		}
		Author auth =  new Author(Integer.parseInt(request.getParameter("author_id")), request.getParameter("author_name"), request.getParameter("author_email"), request.getParameter("author_website"));
		AuthorRepo.getRepo().update(auth);
		request.setAttribute("title", "Edit an Author");
		request.setAttribute("edited", true);
		request.setAttribute("Authors",AuthorRepo.getRepo().getAll());
		return add(request, resp);
	}
}