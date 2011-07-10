package test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {

	public String index(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException{
		request.setAttribute("title","ArchLip Project");
		request.setAttribute("Books", BookRepo.getRepo().getAll());
		return "Home.jsp";
	}
}