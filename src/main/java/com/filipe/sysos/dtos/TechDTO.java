package com.filipe.sysos.dtos;

import com.filipe.sysos.models.Technical;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechDTO {

	private Long id;
	private String name;
	private String cpf;
	private String phone;
	private String email;
	private String sector;
	
	public TechDTO() {
		super();
	}

	public TechDTO(Technical obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.phone = obj.getPhone();
		this.email = obj.getEmail();
		this.sector = obj.getSector();
	}	
}
