package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.SessionProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Note note = new Note(title, content, new Date());
			
			Session session = SessionProvider.getSession();
			Transaction txn = session.beginTransaction();
			session.save(note);
			txn.commit();
			session.close();
			
			response.sendRedirect("viewtasks.jsp");
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println("<h2 style='text-align:center;'>Note is created and added successfully</h2>");
//			out.println("<h2 style='text-align:center;'><a href='viewnotes.jsp'>View all notes<h2>");
			
			System.out.println("Note Created : id-" + note.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
