import java.util.*;
import java.sql.*;

public class StuDemo {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	public static int save(Stu e) {
		int status = 0;;
		try {
			Connection con = StuDemo.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into student (Name, Age, City) values (?, ?, ?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getAge());
			ps.setString(3, e.getCity());
			
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return status;
	}
	
	public static int update(Stu e) {      
        int status = 0;   
        try {    
            Connection con = StuDemo.getConnection();     
            PreparedStatement ps = con.prepareStatement(    
                         "update student set name=?,age=?,city=? where id=?");
            ps.setString(2,e.getName());
            ps.setString(3,e.getAge());
            ps.setString(5,e.getCity());
                
                
            status = ps.executeUpdate();     
                
            con.close();   
        }   
        catch(Exception ex1)    
        {ex1.printStackTrace();}    
            
        return status;      
    }
	
	
}
