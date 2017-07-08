package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.modelo.Funcionario;

public class FuncionarioDAO {
	Connection connection;
	public FuncionarioDAO(Connection connection){
		this.connection = connection;
	}
	
	public void adicona(Funcionario funcionario){
		String sql = "insert into funcionarios "+
					 "(nome,usuario,senha) values(?,?,?)";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Funcionario funcionario){
		String sql = "delete from funcionarios where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Funcionario funcionario){
		String sql = "update funcionarios nome=?, senha=?, usuario=? where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());
			stmt.setString(3, funcionario.getUsuario());
			stmt.setLong(4, funcionario.getId());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Funcionario getFuncionarioById(Long id){
		String sql = "select * from funcionarios where id=?";
		Funcionario funcionario = new Funcionario();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs =  stmt.executeQuery();
			
			while(rs.next()){
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
			}
			
			rs.close();
			stmt.close();
			return funcionario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Funcionario> getList(){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try{
			PreparedStatement stmt = connection.prepareStatement("select * from funcionarios");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				funcionarios.add(funcionario);
			}
			rs.close();
			stmt.close();
			return funcionarios;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
