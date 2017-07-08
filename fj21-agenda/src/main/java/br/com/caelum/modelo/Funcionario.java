package br.com.caelum.modelo;

public class Funcionario {
	private long id;
	private String nome;
	private String usuario;
	private String senha;
	
	public Funcionario() {

	}
	
	public Funcionario(String nome,String usuario,String senha){
		this.setNome(nome);
		this.setUsuario(usuario);
		this.setSenha(senha);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
