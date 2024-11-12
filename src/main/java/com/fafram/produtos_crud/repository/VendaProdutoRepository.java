package com.fafram.produtos_crud.repository;

import com.fafram.produtos_crud.model.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Long> {
}
