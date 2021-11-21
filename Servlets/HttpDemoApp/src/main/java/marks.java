import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class marks extends HttpServlet{
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = Integer.parseInt(req.getParameter("num3"));
		int l = Integer.parseInt(req.getParameter("num4"));
		int m = Integer.parseInt(req.getParameter("num5"));
		int n = Integer.parseInt(req.getParameter("num6"));
		int total = i + j + k + l + m + n;
		float avg = (float) total / 6;
		
		PrintWriter out = res.getWriter();
		out.print("Maths : " + i );
		out.print(" || ");
		out.print("English : " + j );
		out.print(" || ");
		out.print("Hindi : " + k);
		out.print(" || ");
		out.print("Science : " + l);
		out.print(" || ");
		out.print("Social Science : " + m);
		out.print(" || ");
		out.print("IT : " + n);
		out.print(" || ");
		out.print("Total Marks : "+ total);
		out.print(" || ");
		out.printf("Average: %.2f", avg);
	}
}
	