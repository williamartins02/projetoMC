package com.williamartins.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*implementar o SERIALIZABLE 
 * é uma interface que diz que a class sendo implementada "categoria"
 *os objeto dela pode ser convertido com uma sequancia de byte,
 *pra que serve ? - Serve pra dizer q os objeto pode ser gravado em arquivos, trafegar em redes etc..
 *exigencia da linguagem java.
 *.".*/

@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/* atributos da class*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	/*Criando um construtor vazio, ou seja com o construtor 
	 * vazio estancio um objeto sem jogar nada os atributos */
	public Categoria() {
	}
	/*criando um construtor para povoar os dados do atributos*/
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	/*Getters e Setters metodos de acesso ao atributos produtos, instaciado na class categoria..*/
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	/*Getters e Setters metodos de acesso ao atributos Categorias.*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*comparar os objeto com seus conteudo "Hascode".*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
}
