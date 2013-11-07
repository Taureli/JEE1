package com.example.JEE1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/zapis")
public class DataServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String przedmioty = "";
		for (String wybrane : request.getParameterValues("przedmiot")) {
			przedmioty += wybrane + ", ";
		}
		out.println("<html><body><h2>Wprowadzone dane:</h2>" +
				"<p><b>Imie:</b> " + request.getParameter("Imie") + "<br/>"
				+ "<p><b>Nazwisko:</b> " + request.getParameter("Nazwisko") + "<br/>"
				+ "<p><b>Data urodzenia:</b> " + request.getParameter("urodziny") + "<br/>"
				+ "<p><b>Zawod:</b> " + request.getParameter("zawod") + "<br/>"
				+ "<p><b>Wybrane przedmioty:</b> " + przedmioty + "<br/>" +
				"</body></html>");
		out.close();
		
	}
	
}