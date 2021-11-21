import java.io.*;
import jakarta.servlet.*;

public class MyFilter implements Filter {
	public void init(FilterConfig fc) throws ServletException { }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String pass = request.getParameter("pass");
		if(pass.equals("1234")) {
			chain.doFilter(request, response);
		}
		else {
			out.println("You have enter a wrong password");
			RequestDispatcher rs = request.getRequestDispatcher("/index.html");
			rs.include(request, response);
		}
	}
	
	public void destroy() { }
}
