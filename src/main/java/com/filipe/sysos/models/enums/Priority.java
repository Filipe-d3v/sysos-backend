package com.filipe.sysos.models.enums;

public enum Priority {

	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

	private Integer cod;
	private String desc;

	private Priority(Integer cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}


	public static Priority toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Priority x : Priority.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade Inválida!" + cod);
	}
}
