package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.SessionProvider;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("task_id").trim());
			Session session = SessionProvider.getSession();
			Transaction txn = session.beginTransaction();
			
			Note note = (Note) session.get(Note.class, id);
			session.delete(note);
			txn.commit();
			session.close();
			
			response.sendRedirect("viewtasks.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
