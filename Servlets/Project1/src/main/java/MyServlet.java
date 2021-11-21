import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		try {
			String user = req.getParameter("user");
			out.println("<h2 align='center'> Welcome "+ user + "!</h2>");
		}
		finally {
			out.close();
		}
	}
}
