package com.filipe.sysos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filipe.sysos.models.Client;
import com.filipe.sysos.models.Technical;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query("SELECT obj FROM Client obj WHERE obj.cpf =:cpf")
	Technical findByCPF(@Param("cpf") String cpf);
}
