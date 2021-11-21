import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext sc = getServletContext();
		out.println("<center><h2>" + sc.getInitParameter("driverName") + "</h2></center>");
	}
}