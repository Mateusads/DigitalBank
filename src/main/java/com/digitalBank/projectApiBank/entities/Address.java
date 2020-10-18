package com.digitalBank.projectApiBank.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


//cep obrigatório e no formato adequado
//rua obrigatório
//bairro obrigatório
//complemento obrigatório
//cidade obrigatória
//estado obrigatório
//tudo que é obrigatório do passo 1 precisa estar correto

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idAdress;
	
	@Column
	@NotBlank
	@Pattern(regexp= "[0-9]{5}-[0-9]{3}", message = "Invalid Format")
	private String cep;
	@NotBlank
	private String rua;
	@NotBlank
	private String bairro;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	
	@OneToOne
	@JoinColumn(name = "idClient")
	private Client client;
	
	
	public Address() {
	}

	public Address(String cep, String rua, String bairro, String complemento, String cidade, String estado) {
		
		this.idAdress = idAdress;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getIdAdress() {
		return idAdress;
	}


	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
