package com.filipe.sysos.crontrollers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.filipe.sysos.dtos.TechDTO;
import com.filipe.sysos.models.Technical;
import com.filipe.sysos.servicies.TechService;

@RestController
@RequestMapping(value = "/technicals")
public class TechController {

	@Autowired
	private TechService techService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TechDTO> findById(@PathVariable Long id){
		Technical obj = techService.findById(id);
		TechDTO objDTO = new TechDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<TechDTO>> findAll(){
		List<TechDTO> listDTO = techService.findAll().stream().map(obj -> new TechDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<TechDTO> create(@Valid @RequestBody TechDTO objDTO){
		Technical newObj = techService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<TechDTO> update(@PathVariable Long id, @Valid @RequestBody TechDTO objDTO){
		TechDTO newObj = new TechDTO(techService.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<Void> delete(@PathVariable Long id){
		techService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
