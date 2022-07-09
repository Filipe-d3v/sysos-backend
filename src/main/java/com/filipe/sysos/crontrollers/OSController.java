package com.filipe.sysos.crontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.sysos.dtos.OrderServiceDTO;
import com.filipe.sysos.models.OrderService;
import com.filipe.sysos.servicies.OSService;

@RestController
@RequestMapping(value = "/os")
public class OSController {
	
	@Autowired
	private OSService osService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderServiceDTO> findById(@PathVariable Long id){
		OrderService obj = osService.findById(id);
		OrderServiceDTO objDTO = new OrderServiceDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
}
