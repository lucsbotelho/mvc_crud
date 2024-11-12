package com.fafram.produtos_crud.repository;

import com.fafram.produtos_crud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produto, Long>{
}
