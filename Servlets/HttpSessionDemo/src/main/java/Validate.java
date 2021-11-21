import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
public class Validate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String name = request.getParameter("user");
		String pwd = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		out.println("Welcome " + name);
		out.println("Your password is " + pwd);
		
		if(pwd.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", name + "123");
			response.sendRedirect("Welcome");
		}
	}
}
