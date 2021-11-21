import java.io.*;
import java.sql.*;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebServlet("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String lang = request.getParameter("lang");
		String uname = request.getParameter("Username");
		String pass = request.getParameter("Password");
		
		if((uname.equals("admin") && pass.equals("admin") && lang.equals("English")) || 
				(uname.equals("vineetks") && pass.equals("vineetks") && lang.equals("English")))
		{
			chain.doFilter(request, response);
		}
		else {
			try {
				Connection con = SignupValidate.connectDB();
				PreparedStatement ps = con.prepareStatement("SELECT Username, Password, Language FROM Users");
				ResultSet rs = ps.executeQuery();
				int cnt = 0;
				while(rs.next()) {
					String username = rs.getString(1);
					String pwd = rs.getString(2);
					String language = rs.getString(3);
					
					if(username.equals(uname) && pwd.equals(pass) && language.equals(lang)) {
						cnt  = 1;
						break;
					}
				}
				if(cnt == 1) {
					// pass the request along the filter chain
					chain.doFilter(request, response);
				}
				else {
					System.out.println("Credentials not matched... Check the entered language as well.");
					System.out.println("Login Failed");
					RequestDispatcher rqs = request.getRequestDispatcher("loginpage.html");
					rqs.include(request, response);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
