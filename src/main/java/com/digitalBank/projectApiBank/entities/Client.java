package com.digitalBank.projectApiBank.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

import com.sun.istack.NotNull;

@Entity(name = "cliente")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idClient;


	
	@Column
	@NotNull
	private Long cpf;
	private String nome;
	private String sobrenome;
	private String email;
	private Date dataNacimento;


//	@OneToOne
//	@JoinColumn(name = "CPF")
//	private List<Address> address = new ArrayList<>();

	public Client() {
	}

	public Client(Long idClient, String nome, String sobrenome, String email,  Long cpf) {

		this.idClient = idClient;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.dataNacimento = dataNacimento;
		this.cpf = cpf;

	}
	
	public Long getIdClient() {
		
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + cpf);
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
		Client other = (Client) obj;
		if (cpf != other.cpf)
			return false;
		return true;
	}

}
