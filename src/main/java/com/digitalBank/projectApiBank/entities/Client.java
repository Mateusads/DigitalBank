package com.digitalBank.projectApiBank.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

//nome do cliente é obrigatório
//sobrenome do cliente é obrigatório
//email é obrigatório e precisa ter formato de email
//cpf é obrigatório e precisa respeitar o formato
//data de nascimento obrigatório, no passado e tem que ter mais de 18 anos
//email não pode ser duplicado
//cpf não pode ser duplicado


@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idClient;
	
	@Column(unique = true)
	@NotEmpty
	@Pattern(regexp= "^((\\d{3}).(\\d{3}).(\\d{3})-(\\d{2}))*$", message = "Invalid Format")
	private String cpf;
	
	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Invalid Format")
	private String email;

	@NotBlank
	private String nome;	
	@NotBlank
	private String sobrenome;
	@NotNull
	private LocalDate dataNascimento;

	@JsonIgnore
	@ManyToOne
	private Address adress;
	
	@JsonIgnore
	@ManyToOne
	private ImgCPF imgCPF;


	public Client() {
	}

	public Client(String nome, String sobrenome, String email,  String cpf, LocalDate dataNascimento) {


		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;


	}
	
	public Long getIdClient() {
		
		return idClient;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getAgeClient(LocalDate dataNascimento) {
		LocalDate now = LocalDate.now();
		Period period = Period.between(dataNascimento, now);
		int age = period.getYears();
		return age;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public ImgCPF getImgCPF() {
		return imgCPF;
	}


	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}






}
