import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String userId = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		if(pwd.equals("patternfly")) {
			/*RequestDispatcher rd = request.getRequestDispatcher("display1");
			rd.forward(request, response);*/
			try {
				response.sendRedirect("https://www.studytonight.com");
			}
			finally {
				out.close();
			}
		}
		else {
			out.print("<font color = 'red'><b>Incorrect UserID or Password</b></font>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	}
}
