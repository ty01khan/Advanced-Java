import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pass");
		
		if(Validate.checkUser(email, pwd)) {
			out.println("Logged In Successfully");
			response.sendRedirect("Welcome");
		}
		else {
			out.println("Username or Password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.include(request, response);
		}
	}
}
