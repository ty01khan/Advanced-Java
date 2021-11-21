import java.io.*;
import jakarta.servlet.*;

public class DemoServlet implements Servlet {	
   ServletConfig config = null;
   
   public void init(ServletConfig config){	
      this.config=config;	
   }	
   
   public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {	
       res.setContentType("text/html");	
       PrintWriter pwriter = res.getWriter();	
       pwriter.print("<html>");	
       pwriter.print("<body>");	
       pwriter.print("<h1>Hello Welcome to Patternfly. This example is of servlet interface. </h1>");
       pwriter.print("<input>");
       pwriter.print("</body>");
       pwriter.print("</html>");
   }
   
   public void destroy(){	
       System.out.println("servlet destroy");
   }
   
   public ServletConfig getServletConfig(){	
       return config;	
   }
   
   public String getServletInfo(){	
       return "patternfly.com";	
   }
}	