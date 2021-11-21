import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pass");
		
		try {
			// loading drivers for mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// creating connection with the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			
			PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pwd);
			int i = ps.executeUpdate();
			
			if(i > 0) {
				out.println("You are successfully registered");
			}
			else {
				out.println("Registraton failed");
			}
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
