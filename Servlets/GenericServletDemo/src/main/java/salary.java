import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;


public class salary extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("basicSal"));
		int j = Integer.parseInt(req.getParameter("da"));
		int k = Integer.parseInt(req.getParameter("hra"));
		int da = (i*j)/100;
		int hra = (i*k)/100;
		int grossSal = i + da + hra;
		
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<center><h2>PATTERNFLY</h2></center>");
		out.println("<b>DA: " + da + "</b><br><br>");
		out.println("<b>HRA: " + hra + "</b><br><br>");
		out.println("<b>Gross Salary: " + grossSal + "</b>");
		out.print("</html>");
		out.print("</body>");
	}
	
	public void destroy(){	
		System.out.println("servlet destroy");
	}
	   
	public String getServletInfo(){	
		return "patternfly.com";	
	}
}
