package com.digitalBank.projectApiBank.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digitalBank.projectApiBank.entities.ImgCPF;

@Repository
public interface ImgCPFRepository extends JpaRepository<ImgCPF, Long>{





}