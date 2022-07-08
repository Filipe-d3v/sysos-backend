package com.filipe.sysos.dtos;

import org.hibernate.validator.constraints.br.CPF;

import com.filipe.sysos.models.Client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {

	private Long id;
	private String name;
	 @CPF
	private String cpf;
	private String phone;
	private String address;
	
	public ClientDTO() {
		super();
	}

	public ClientDTO(Client obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.phone = obj.getPhone();
		this.address = obj.getAddress();
	}	
}
