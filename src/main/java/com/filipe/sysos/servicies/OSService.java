package com.filipe.sysos.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.sysos.models.OrderService;
import com.filipe.sysos.repositories.OSRepository;
import com.filipe.sysos.servicies.exceptions.ObjectNotFoundException;

@Service
public class OSService {

	@Autowired
	private OSRepository osRepository;
	
	public OrderService findById(Long id) {
		Optional<OrderService> obj = osRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + OrderService.class.getName()));
	}
}
