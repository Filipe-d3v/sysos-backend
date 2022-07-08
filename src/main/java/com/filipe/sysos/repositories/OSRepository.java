package com.filipe.sysos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filipe.sysos.models.OrderService;

@Repository
public interface OSRepository extends JpaRepository<OrderService, Long>{

}
