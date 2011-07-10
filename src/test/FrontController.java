package test;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {

	// URLs must have the form /polling/ControllerClass.action
	// the execute() method of the ControllerClass will be called
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String className = request.getServletPath();
		String defaultController = "Home";
		String defaultMethod = "index";
		String method;
		String[] parameters = null;
		className = className.substring(1, className.length()-3);
		if (className == null || className.equals("")) {
			className = defaultController;
			method = defaultMethod;
		}else if (className.indexOf("-") == -1) {
			method = defaultMethod;
		}else {
			method = className.substring(className.indexOf("-")+1);
			className = className.substring(0,className.indexOf("-"));
		}
		String tmp = "";
		if (method.indexOf("-") != -1) {
			tmp = new String(method);
			method = method.substring(0,method.indexOf("-"));
			tmp = tmp.substring(method.length()+1);
			parameters = tmp.split("-");
		}
		
		request.setAttribute("parameters", parameters);
		try {
			Class ctrlClass = Class.forName("test." + className + "Controller");
			Method m = ctrlClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			String forward = (String)m.invoke(ctrlClass.newInstance(), request, response);
			//response.getOutputStream().println("redirecting: " + forward);
			request.getRequestDispatcher(forward).forward(request, response);
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
			response.setContentType("text/html");
			if (ex.getTargetException() instanceof SQLException)
				response.getOutputStream().println("Error in accessing database!<p>Contact system administrator");
			else
				response.getOutputStream().println("!Internal system error!<p>Contact system administrator");
		} catch (Exception e) {
			response.getOutputStream().println(e.getMessage());
			response.setContentType("text/html");
			e.printStackTrace();
			//response.getOutputStream().
			response.getOutputStream().println("@Internal system error!<p>Contact system administrator");
		}
		/**/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}