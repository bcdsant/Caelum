package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;
import br.com.caelum.modelo.Contato;

public class ContatoDAO {
	private Connection connection;
	
	public ContatoDAO(Connection connection){
		this.connection = connection;
	}
	
	public void adiciona(Contato contato){
		//Definindo a o modelo do comando SQL
		String sql = "insert into contatos "+
					 "(nome,email,endereco,dataNascimento)"+
					 "values (?,?,?,?)";
		try{
			//Prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Contato> getList() {
		
		List<Contato> contatos = new ArrayList<Contato>();
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				Calendar data = Calendar.getInstance();
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setId(rs.getLong("id"));
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Contato> getContatoByName(String nome){
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "select * from contatos where nome like ?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%"+nome+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				Calendar data = Calendar.getInstance();
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setId(rs.getLong("id"));
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
						
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public Contato getContatoById(long id){
		Contato contato = new Contato();
		Calendar data = Calendar.getInstance();
		String sql = "select * from contatos where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//System.out.println("consulta = "+rs.getString("id"));
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setId(rs.getLong("id"));
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			return contato;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato){
		String sql = "delete from contatos where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
