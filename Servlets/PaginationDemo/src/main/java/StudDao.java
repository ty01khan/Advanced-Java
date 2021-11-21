import java.sql.*;
import java.util.*;

public class StudDao {
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
	
	public static List<pStudGetSet> getRecords(int start, int total) {
		List<pStudGetSet> list = new ArrayList<pStudGetSet>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student limit " + (start-1) + "," + (total));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pStudGetSet e = new pStudGetSet();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getString(3));
				e.setCity(rs.getString(4));
				list.add(e);
			}
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
}
