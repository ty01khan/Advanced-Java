import java.sql.*;

public class Validate {
	public static boolean checkUser(String email, String pass) {
		boolean st = false;
		try {
			// loading driver for mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Student WHERE EmailID=? AND Password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return st;
	}
}