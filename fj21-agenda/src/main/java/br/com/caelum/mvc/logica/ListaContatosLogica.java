package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class ListaContatosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ContatoDAO dao = new ContatoDAO((Connection) req.getAttribute("connection"));
		List<Contato> contatos = dao.getList();
		req.setAttribute( "contatos", contatos );
		return "/WEB-INF/jsp/lista-contatos-displaytag.jsp"; 
	}

}
