import java.sql.*;
import jakarta.servlet.*;

public class MyListener implements ServletContextListener {
	ServletContext ctx;
	Connection con;
	Statement s;
	PreparedStatement ps;
	ResultSet rs;
	int count = 0;
	
	public void contextInitalized(ServletContextEvent sce) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			
			s = con.createStatement();
			
			// fetching page views value from table counter
			rs = s.executeQuery("select pageview from counter");
			
			while(rs.next()) {
				count = rs.getInt(1);
				System.out.print(count);
			}
			
			ctx = sce.getServletContext();
			ctx.setAttribute("pcount", count);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			ctx = sce.getServletContext();
			count = (Integer)ctx.getAttribute("pcount");
			ps = con.prepareStatement("update counter set pcount='"+count+"' ");
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
