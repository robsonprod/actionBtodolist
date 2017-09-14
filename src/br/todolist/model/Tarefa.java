package br.todolist.model;

public class Tarefa {
	private Long id;
	private String nome;
	private String descricao;
	private Long user_id;
	
	public Tarefa() {

	}
	
	public Tarefa(String nome, String descricao, Long user_id) {
		this.nome = nome;
		this.descricao = descricao;
		this.user_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
}
