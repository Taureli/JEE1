package com.example.JEE1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Wypelnienie formularza:</h2>"
				+ "<form action='zapis'>"
				+ "Podaj imie: <br/><input type='text' name='Imie'/><br/>"
				+ "Podaj nazwisko: <br/><input type='text' name='Nazwisko'/><br/>"
				+ "Podaj date urodzenia: <br/><input type='date' name='urodziny'><br/>"
				+ "<br/>Wybierz swoj zawod:<br/>"
				+ "<input type='radio' name='zawod' value='nauczyciel'>Nauczyciel<br/>"
				+ "<input type='radio' name='zawod' value='student'>Student<br/>"
				+ "<br/>Wybierz swoje przedmioty:<br/>"
				+ "<input type='checkbox' name='przedmiot' value='Java'>Java "
				+ "<input type='checkbox' name='przedmiot' value='Scala'>Scala "
				+ "<input type='checkbox' name='przedmiot' value='Szeregowanie'>Szeregowanie zadan "
				+ "<br/><br/><input type='submit' value='Zatwierdz' />"
				+ "</form>"
				+ "</body></html>");
		
		
		
		
		out.close();
		
	}
	
}