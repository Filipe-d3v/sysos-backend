package com.filipe.sysos.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filipe.sysos.models.OrderService;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderServiceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateOpen;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateClose;
	private Integer priority;
	private Integer status;
	private String obs;
	private Long client;
	private Long technical;
	
	public OrderServiceDTO() {
		super();
	}

	public OrderServiceDTO(OrderService obj) {
		super();
		this.id = obj.getId();
		this.dateOpen = obj.getDateOpen();
		this.dateClose = obj.getDateClose();
		this.priority = obj.getPriority().getCod();
		this.status = obj.getStatus().getCod();
		this.obs = obj.getObs();
		this.client = obj.getClient().getId();
		this.technical = obj.getTechnical().getId();
	}
}
