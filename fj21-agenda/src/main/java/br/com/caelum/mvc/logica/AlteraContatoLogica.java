package br.com.caelum.mvc.logica;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class AlteraContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		ContatoDAO dao = new ContatoDAO((Connection) req.getAttribute("connection"));
		Contato contato = dao.getContatoById(id);
		req.setAttribute("contato", contato);
		return "/WEB-INF/jsp/alteraContato.jsp";
	}

}
