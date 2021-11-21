import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class First extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user_name");
        out.println("Welcome "+user);
    }
}
