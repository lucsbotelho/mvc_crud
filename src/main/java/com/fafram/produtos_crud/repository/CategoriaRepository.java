package com.fafram.produtos_crud.repository;

import com.fafram.produtos_crud.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
}
