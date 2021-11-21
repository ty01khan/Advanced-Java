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

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id").trim());
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Session session = SessionProvider.getSession();
			Transaction txn = session.beginTransaction();
			
			Note note = session.get(Note.class, id);
			note.setTitle(title);
			note.setContent(content);
			
			session.update(note);
			txn.commit();
			session.close();
			
			response.sendRedirect("viewtasks.jsp");
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println("<h2 style='text-align:center;'>Note is created and added successfully</h2>");
//			out.println("<h2 style='text-align:center;'><a href='viewnotes.jsp'>View all notes<h2>");
			
			System.out.println("Task Updated : id-" + id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
