package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class AdicionaContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataText = req.getParameter("dataNascimento");
		Long id = null;
		Calendar dataNascimento = null;
		
		try{
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataText);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		}catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
		Contato contato = new Contato();
		contato.setName(nome);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		contato.setEndereco(endereco);

		ContatoDAO dao;
		dao = new ContatoDAO((Connection) req.getAttribute("connection"));
		
		
		if (req.getParameter("id") != null){
			id  = Long.parseLong(req.getParameter("id"));
			contato.setId(id);
			dao.altera(contato);
			req.setAttribute("msg", "alterado");
			return "/WEB-INF/jsp/contato-adicionado.jsp";
		}else{
			dao.adiciona(contato);
			req.setAttribute("msg", "adicionado");
			return "/WEB-INF/jsp/contato-adicionado.jsp";
		}
		
		
		
	}

}
