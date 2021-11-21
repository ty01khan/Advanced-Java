import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/PageViewServlet")
public class PageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String spageId = request.getParameter("page");
		int pageId = Integer.parseInt(spageId);
		int total = 20;
		if(pageId != 1) {
			pageId = pageId - 1;
			pageId = pageId * total + 1;
		}
		
		List<pStudGetSet> list = StudDao.getRecords(pageId, total);
		
		out.print("<h1>patternfly Page No: " + spageId + "</h1>");
		out.print("<table border = '1' cellpadding = '4' width = '60%'>");
		out.print("<tr>"
				+ "<th>Id</th>"
				+ "<th>Name</th>"
				+ "<th>Age</th>"
				+ "<th>City</th>"
				+ "</tr>");
		
		for(pStudGetSet e1 : list) {
			out.print("<tr>"
					+ "<td>" + e1.getId() + "</td>"
					+ "<td>" + e1.getName() + "</td>"
					+ "<td>" + e1.getAge() + "</td>"
					+ "<td>" + e1.getCity() + "</td>"
					+ "</tr>");
		}
		out.print("</table>");
		
		out.println("<br/><br/>");
		out.print("<a href = 'PageViewServlet?page=1'>ViewPage1</a>");
		out.println("<br/><br/>");
		out.println("<br/><br/>");
		out.print("<a href = 'PageViewServlet?page=2'>ViewPage2</a>");
		out.println("<br/><br/>");
		out.println("<br/><br/>");
		out.print("<a href = 'PageViewServlet?page=3'>ViewPage3</a>");
		
		out.close();
	}
}
