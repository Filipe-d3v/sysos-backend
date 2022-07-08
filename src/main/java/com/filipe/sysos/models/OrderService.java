package com.filipe.sysos.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filipe.sysos.models.enums.Priority;
import com.filipe.sysos.models.enums.Status;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class OrderService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern = "dd/MM/yy HH:mm")
	private LocalDateTime dateOpen;
	@JsonFormat(pattern = "dd/MM/yy HH:mm")
	private LocalDateTime dateClose;
	private Integer priority;
	private Integer status;
	private String obs;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "tech_id")
	private Technical technical;
	
	public OrderService() {
		super();
		this.setDateOpen(LocalDateTime.now());
		this.setPriority(Priority.BAIXA);
		this.setStatus(Status.ANDAMENTO);
	}

	public OrderService(Long id, LocalDateTime dateClose, Priority priority, Status status,
			String obs, Client client, Technical technical) {
		super();
		this.id = id;
		this.setDateOpen(LocalDateTime.now());
		this.dateClose = dateClose;
		this.priority = (priority == null) ? 0 : priority.getCod();
		this.status = (status == null) ? 0 : status.getCod();
		this.obs = obs;
		this.client = client;
		this.technical = technical;
	}
	
	public Priority getPriority() {
		return Priority.toEnum(this.priority);
	}

	public void setPriority(Priority priority) {
		this.priority = priority.getCod();
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}
	
}
