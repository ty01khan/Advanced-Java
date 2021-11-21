import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class cookie1 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("val1");
			out.print("Welcome " + name);
			
			Cookie ck = new Cookie("uname", name);
			response.addCookie(ck);
			out.print("<form action = 'pqr' method = 'post'>");
			out.print("<input type = 'submit' value = 'Go'>");
			out.print("</form>");
			out.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
