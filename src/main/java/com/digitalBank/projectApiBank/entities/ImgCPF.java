package com.digitalBank.projectApiBank.entities;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
=======

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

>>>>>>> main
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ImgCPF {
	
	@Id
	@GeneratedValue
	private Long idImgCPF;	

	@NotEmpty
	private String nameImg;
	
	@JsonIgnore
	@OneToMany
	private List<Client> client = new ArrayList<>();

	public ImgCPF(@NotEmpty String nameImg) {
		
		this.nameImg = nameImg;
	}

	public Long getIdImgCPF() {
		return idImgCPF;
	}

	public void setIdImgCPF(Long idImgCPF) {
		this.idImgCPF = idImgCPF;
	}

	public String getNameImg() {
		return nameImg;
	}

	public void setNameImg(String nameImg) {
		this.nameImg = nameImg;
	}

	public List<Client> getClient() {
		return client;
	}


	
	
	
	
	

}
