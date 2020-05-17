package br.com.bruna.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.bruna.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message="O preenchimento do nome da categoria é obrigatório")
	@Length(min=5, max=80, message="O nome da categoria deve conter entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
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

	public void setName(String nome) {
		this.nome = nome;
	}
	
	

}
