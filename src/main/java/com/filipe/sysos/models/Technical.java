package com.filipe.sysos.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Technical extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "technical")
	private List<OrderService> list = new ArrayList<>();
	
	private String email;
	private String sector;

	public Technical() {
		super();
	}

	public Technical(Long id, String name, String cpf, String phone, String email, String sector) {
		super(id, name, cpf, phone);
		this.email = email;
		this.sector = sector;
	}
}
