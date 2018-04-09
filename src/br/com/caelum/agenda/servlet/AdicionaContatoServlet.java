package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (java.text.ParseException e) {
			out.println("Erro de conversão de data");
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);

		RequestDispatcher rd = req.getRequestDispatcher("sucesso.jsp");
		rd.forward(req, resp);

		// out.println("<html><body>Contato adicionado com Sucesso");
		// out.println("<br/> <a href='http://localhost:8080/fj21-agenda/adiciona-contato.html'>Cadastrar Novamente</a>");
		// out.println("<br/> <a href='http://localhost:8080/fj21-agenda/lista-contatos.jsp'>Visualizar Contatos</a>");
		// out.println("</body></html>");

	}
}
