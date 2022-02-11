package com.rrgayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrgayer.model.Boleto;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long>{

}
