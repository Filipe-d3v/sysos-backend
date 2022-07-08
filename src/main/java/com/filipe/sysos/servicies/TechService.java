package com.filipe.sysos.servicies;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.sysos.crontrollers.exceptions.ViolationException;
import com.filipe.sysos.dtos.TechDTO;
import com.filipe.sysos.models.Person;
import com.filipe.sysos.models.Technical;
import com.filipe.sysos.repositories.TechRepository;


@Service
public class TechService {
	
	@Autowired
	private TechRepository techRepository;

	public Technical findById(Long id) {
		Optional<Technical> obj = techRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Technical.class.getName(), null));
	}
	
	public List<Technical> findAll() {
		return techRepository.findAll();
	}
	
	public Technical create( TechDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new ViolationException("CPF Já Cadastrado!");
		}
		return  techRepository.save(new Technical(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone(), objDTO.getEmail(), objDTO.getSector()));
		
		
	}
	
	private Person findByCPF(TechDTO objDTO) {
		Person obj = techRepository.findByCPF(objDTO.getCpf());

		if (obj != null) {
			return obj;
		}
		return null;
	}
	
	public Technical update(Long id, @Valid TechDTO objDTO) {
		Technical oldObj = findById(id);
		
		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new ViolationException("CPF Já cadastrado!");
		}
		
		oldObj.setName(objDTO.getName());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setEmail(objDTO.getEmail());
		oldObj.setPhone(objDTO.getPhone());
		oldObj.setSector(objDTO.getSector());
		return techRepository.save(oldObj);
	}
	
	public void delete(Long id) {
		Technical obj = findById(id);
		if(obj.getList().size() > 0) {
			throw new ViolationException("Ordem de serviço associada ao técnico, não pode ser deletado!");
		}
		techRepository.deleteById(id);
	}
}
