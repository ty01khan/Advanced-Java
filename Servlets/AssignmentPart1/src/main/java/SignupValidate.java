import java.sql.*;
import java.time.Period;
import java.time.LocalDate;

public class SignupValidate {
	public static boolean isValid(String name, String uname, String contact, int eid, String address, String gender, String lang,
			String imageFileName, String dob, String email, String pass, String cpass) {
		// TODO Auto-generated method stub
		if(name.isBlank() || uname.isBlank() || contact.isBlank() || address.isBlank() 
				|| gender.isBlank() || lang.isBlank() || dob.isBlank()
				|| imageFileName.isBlank() || email.isBlank() 
				|| pass.isBlank()|| cpass.isBlank()) {
			return false;
		}
		
		if(contact.length() == 10) {
			int i;
			for(i = 0; i < contact.length(); i++) {
				char ch = contact.charAt(i);
				if((int)ch > 57 || (int)ch < 48) {
					break;
				}
			}
			if(i != contact.length()) {
				System.out.println("Contact number must contain digits only");
				return false;
			}
		}
		else {
			System.out.println("Contact number must be of 10 digits");
			return false;
		}
		
		if(Period.between(LocalDate.parse(dob), LocalDate.now()).getYears() < 20) {
			System.out.println("Age should be atleast 20 years");
			return false;
		}
		
		if(!pass.equals(cpass)) {
			System.out.println("Passwords are not same");
			return false;
		}
		
		try {
			Connection con = connectDB();
			PreparedStatement ps = con.prepareStatement("SELECT EmployeeID, EmailID, Username FROM Users");
			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				int empId = rs.getInt(1);
				String emailId = rs.getString(2);
				String username = rs.getString(3);
				
				if(empId == eid || emailId.equals(email) || username.equals(uname)) {
					cnt  = 1;
					System.out.println("Not an unique Employee ID or Email ID or Username");
					break;
				}
			}
			
			if(cnt == 1) {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return true;
	}
	
	public static Connection connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Servlet", "root", "");
			
			return con;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
