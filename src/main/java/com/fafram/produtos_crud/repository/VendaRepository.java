package com.fafram.produtos_crud.repository;

import com.fafram.produtos_crud.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long>{
}
