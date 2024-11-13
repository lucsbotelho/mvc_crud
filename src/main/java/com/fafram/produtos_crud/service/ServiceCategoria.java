package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.Categoria;
import com.fafram.produtos_crud.repository.CategoriaRepository;
import com.fafram.produtos_crud.utils.CategoriaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoria implements InterfaceCategoria{

    @Autowired
    private CategoriaRepository categorias;

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        return categorias.save(categoria);
    }

    @Override
    public Categoria procurarPorId(Integer id) {
        Optional<Categoria> listaCategoria = categorias.findById(id);
        if (listaCategoria.isPresent()){
            return listaCategoria.get();
        } else{
            throw new CategoriaNaoEncontradaException("Categoria" + id + "não encontrada");
        }
    }

    @Override
    public List<Categoria> verTodosCategoria() {
        return categorias.findAll();
    }

    @Override
    public void atualizarCategoria(Categoria categoria) {
        categorias.save(categoria);
    }

    @Override
    public void deletarCategoria(Integer id) {
        categorias.delete(procurarPorId(id));
    }
}
