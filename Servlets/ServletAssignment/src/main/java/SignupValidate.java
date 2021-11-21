import java.sql.*;

public class SignupValidate {
	public static boolean isValid(String name, String contact, int eid, String address, String gender, String lang,
			String imageFileName, String dob, String email, String pass, String cpass) {
		// TODO Auto-generated method stub
		if(name.isBlank() || contact.isBlank() || address.isBlank() 
				|| gender.isBlank() || lang.isBlank() || dob == ""
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
				return false;
			}
		}
		else {
			return false;
		}
		
		if(!pass.equals(cpass)) {
			System.out.println("Passwords are not same");
			return false;
		}
		
		try {
			Connection con = connectDB();
			PreparedStatement ps = con.prepareStatement("SELECT EmployeeID, Email FROM userdetails");
			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				int empId = rs.getInt(1);
				String emailId = rs.getString(2);
				
				if(empId == eid || emailId.equals(email)) {
					cnt  = 1;
					System.out.println("Not an unique Employee ID or Email ID");
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
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PatternFly", "rohit", "211099");
			
			return con;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}