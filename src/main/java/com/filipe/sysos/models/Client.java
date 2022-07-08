package com.filipe.sysos.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Client extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String address;

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<OrderService> list = new ArrayList<>();

	public Client() {
		super();
	}

	public Client(Long id, String name, String cpf, String phone, String address) {
		super(id, name, cpf, phone);
		this.address = address;
	}

	
}
