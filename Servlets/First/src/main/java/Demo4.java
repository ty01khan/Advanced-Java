import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

@SuppressWarnings("serial")
public class Demo4 extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   {
     //res.setContentType("text/html");
     PrintWriter pwriter = res.getWriter();
     String uname = req.getParameter("val1");
     String pw = req.getParameter("val2");
     pwriter.println("User Details Page:");
     pwriter.println("Hello "+uname);
     pwriter.println("Your Password is **"+pw+"**");
     pwriter.close();
  }
}