import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
public class Counter extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext ctx = getServletContext();
        Integer count = (Integer)ctx.getAttribute("pcount");
        out.println(count + ": pageview");
        ctx.setAttribute("pcount", ++count);    
    }
}