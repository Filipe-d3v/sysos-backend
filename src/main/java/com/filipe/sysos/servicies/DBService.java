package com.filipe.sysos.servicies;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.sysos.models.Client;
import com.filipe.sysos.models.OrderService;
import com.filipe.sysos.models.Technical;
import com.filipe.sysos.models.enums.Priority;
import com.filipe.sysos.models.enums.Status;
import com.filipe.sysos.repositories.ClientRepository;
import com.filipe.sysos.repositories.OSRepository;
import com.filipe.sysos.repositories.TechRepository;

@Service
public class DBService {
	
	@Autowired
	private TechRepository techRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OSRepository osRepository;

	
	public void instanciaDB() {
		
		Technical t1 = new Technical(null, "Filipe Pereira da Silva", "121.984.146-35", "999088972", "filipe@mail.com", "Manutenção");
		Technical t2 = new Technical(null, "Fulano de Tal", "716.975.370-73", "929845623", "fulano@mail.com", "Internete");
		
		Client c1 = new Client(null, "Beltrano da Silva", "768.386.020-40", "963524231", "Rua dos viajantes 251 - centro");
		Client c2 = new Client(null, "Siprinao Pereira", "821.360.430-05", "989745632", "Avenida larga 00 - periferia sul");
		
		OrderService os1 = new OrderService(null, null, Priority.ALTA, Status.ANDAMENTO, "Entrada Carregador ta ruim", c2, t2);
		OrderService os2 = new OrderService(null, null, Priority.BAIXA, Status.PRONTO, "Colocar HD de 500", c1, t1);
		
		techRepository.saveAll(Arrays.asList(t1));
		techRepository.saveAll(Arrays.asList(t2));
		clientRepository.saveAll(Arrays.asList(c1));
		clientRepository.saveAll(Arrays.asList(c2));
		osRepository.saveAll(Arrays.asList(os1));
		osRepository.saveAll(Arrays.asList(os2));
	}
}
