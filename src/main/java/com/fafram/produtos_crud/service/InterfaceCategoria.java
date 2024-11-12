package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.Categoria;


import java.util.List;

public interface InterfaceCategoria {

    public Categoria salvarCategoria(Categoria categoria);
    public Categoria procurarPorId(Integer id);
    public List<Categoria> verTodosCategoria();
    public void atualizarCategoria(Categoria categoria);
    public void deletarCategoria(Integer id);
}
