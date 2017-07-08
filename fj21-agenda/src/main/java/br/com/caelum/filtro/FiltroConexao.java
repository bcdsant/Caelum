package br.com.caelum.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.factory.ConnectionFactory;


@WebFilter("/mvc")
public class FiltroConexao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// abre uma conexão
		Connection connection;
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e){
			throw new RuntimeException(e);
		}
		
		// "pendura um objeto no Request"
		request.setAttribute("connection", connection);
		
		// indica que o processamento do request deve prosseguir
		chain.doFilter(request, response);
		
		// fecha conex�o
		try {
			connection.close();
		} catch (SQLException e){
			throw new RuntimeException(e);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
