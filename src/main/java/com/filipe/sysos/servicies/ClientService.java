package com.filipe.sysos.servicies;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.sysos.crontrollers.exceptions.ViolationException;
import com.filipe.sysos.dtos.ClientDTO;
import com.filipe.sysos.models.Client;
import com.filipe.sysos.models.Person;
import com.filipe.sysos.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Client.class.getName(), null));
	}
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client create( ClientDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new ViolationException("CPF Já Cadastrado!");
		}
		return  clientRepository.save(new Client(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone(), objDTO.getAddress()));
		
		
	}
	
	private Person findByCPF(ClientDTO objDTO) {
		Person obj = clientRepository.findByCPF(objDTO.getCpf());

		if (obj != null) {
			return obj;
		}
		return null;
	}
	
	public Client update(Long id, @Valid ClientDTO objDTO) {
		Client oldObj = findById(id);
		
		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new ViolationException("CPF Já cadastrado!");
		}
		
		oldObj.setName(objDTO.getName());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setAddress(objDTO.getAddress());
		oldObj.setPhone(objDTO.getPhone());
		return clientRepository.save(oldObj);
	}
	
	public void delete(Long id) {
		Client obj = findById(id);
		if(obj.getList().size() > 0) {
			throw new ViolationException("Ordem de serviço associada ao cliente, não pode ser deletado!");
		}
		clientRepository.deleteById(id);
	}
}
