package com.fafram.produtos_crud.repository;

import com.fafram.produtos_crud.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
