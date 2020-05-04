package com.projet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.entites.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	@Query("select o from Operation o where o.compte.codeCompte=: x order by o.dateOpertion desc")
	public Page<Operation> listOperation(@Param("x")String codeCompte,PageRequest of);

	
	
}