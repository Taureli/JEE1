package com.example.JEE1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/sesja")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("lokalna")==null)
			session.setAttribute("lokalna", new Integer(0));
		
		Integer licznikSesji = (Integer) session.getAttribute("lokalna");
		licznikSesji++;
		session.setAttribute("lokalna", licznikSesji);
		
		Integer licznikGlobalny = (Integer) getServletContext().getAttribute("globalna");
		licznikGlobalny++;
		getServletContext().setAttribute("globalna", licznikGlobalny);
		
		PrintWriter out = response.getWriter();
		out.println("<html><h2>Stan sesji:</h2><br/>Lokalnie: </html>");
		out.println(session.getAttribute("lokalna"));
		out.println("<html><br/>Globalnie: </html>");
		out.println(getServletContext().getAttribute("globalna"));
		out.close();
	}
	
	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("globalna", new Integer(0));
	}

}
