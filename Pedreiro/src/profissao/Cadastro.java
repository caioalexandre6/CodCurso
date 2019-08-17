package profissao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String profissao = request.getParameter("profissao");
		out.println("<html>"
				+ "<body>"
				+ "<h1> Meu nome é : "+ nome + "</h1>"
				+ "<h1> Minha profissao é : "+ profissao + "</h1>"
				+ "<body></html>"
				);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
