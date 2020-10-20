package com.digitalBank.projectApiBank.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
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
