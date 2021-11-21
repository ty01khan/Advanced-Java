import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class cookie2 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			Cookie[] ck = request.getCookies();
			out.print("Hello " + ck[0].getValue());
			out.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
