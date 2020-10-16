package com.digitalBank.projectApiBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalBank.projectApiBank.entities.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	


}
