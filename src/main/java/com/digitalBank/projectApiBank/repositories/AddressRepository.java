package com.digitalBank.projectApiBank.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalBank.projectApiBank.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{





}