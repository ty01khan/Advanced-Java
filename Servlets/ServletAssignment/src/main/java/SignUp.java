import java.io.*;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class SignupServlet
 */
@MultipartConfig
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String contact = request.getParameter("phone-number");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String lang = request.getParameter("Language");
		Part file = request.getPart("profilepic");
		String imageFileName = file.getSubmittedFileName();	
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		
		int eid;
		if(!request.getParameter("EID").isBlank()) {
			eid = Integer.parseInt(request.getParameter("EID"));
			
			if(SignupValidate.isValid(name, contact, eid, address, gender, lang, imageFileName, dob, email, pass, cpass)) {
				try {
					// loading drivers for mysql
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// creating connection with the database
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PatternFly", "rohit", "211099");
					PreparedStatement ps = con.prepareStatement("INSERT INTO userdetails VALUES (?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1, name);
					ps.setString(2, contact);
					ps.setInt(3, eid);
					ps.setString(4, address);
					ps.setString(5, gender);
					ps.setString(6, lang);
					ps.setString(7, imageFileName);
					ps.setString(8, dob);
					ps.setString(9, email);
					ps.setString(10, pass);
					
					int row = ps.executeUpdate();
					if(row > 0) {
						System.out.println("Data added into database successfully");
					}
					else {
						System.out.println("Failed to add data into database");
					}
					
					out.println("Signup Successfully");
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else {
				System.out.println("Signup failed");
				out.println("Signup Failed");
				RequestDispatcher rs = request.getRequestDispatcher("sign-up.html");
				rs.include(request, response);
			}
		}
		else {
			out.println("Signup Failed");
			RequestDispatcher rs = request.getRequestDispatcher("sign-up.html");
			rs.include(request, response);
		}
	}

}