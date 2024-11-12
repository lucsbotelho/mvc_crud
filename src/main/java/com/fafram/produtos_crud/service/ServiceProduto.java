package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.Produto;
import com.fafram.produtos_crud.repository.ProductRepository;
import com.fafram.produtos_crud.utils.ProdutoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProduto implements InterfaceServiceProduto{

    @Autowired
    private ProductRepository produto;

    @Override
    public Produto salvarProduto(Produto product){
        return produto.save(product);
    }

    @Override
    public Produto procurarPorId(Long id) {
        Optional<Produto> product = produto.findById(id);
        if (product.isPresent()){
            return product.get();
        } else{
            throw new ProdutoNaoEncontradoException("Produto" + id + "não encontrado");
        }
    }

    @Override
    public List<Produto> verTodosProdutos() {
        return produto.findAll();
    }

    @Override
    public void atualizarProdutos(Produto product) {
        produto.save(product);

    }

    @Override
    public void deletarProdutos(Long id) {
        produto.delete(procurarPorId(id));
    }

}
