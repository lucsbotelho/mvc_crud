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

    @Override
    public void adicionarEstoque(Long id, int quantidadeAdicionada) {
        Optional<Produto> produtoEstoque = produto.findById(id);
        if(produtoEstoque.isPresent()){
            Produto produtoAdicionado = produtoEstoque.get();
            produtoAdicionado.setQuantidadeEstoque(produtoAdicionado.getQuantidadeEstoque() + quantidadeAdicionada);
            produto.save(produtoAdicionado);
        }
        else{
            throw new ProdutoNaoEncontradoException("Produto" + id + "não encontrado");
        }
    }

    public void removerDoEstoque(Long id, int quantidadeRetirada) throws IllegalAccessException {
        Optional<Produto> produtoEstoque = produto.findById(id);
        if(produtoEstoque.isPresent()){
            Produto produtoRemovido = produtoEstoque.get();
            if(produtoRemovido.getQuantidadeEstoque() >= quantidadeRetirada){
                produtoRemovido.setQuantidadeEstoque(produtoRemovido.getQuantidadeEstoque() - quantidadeRetirada);
                produto.save(produtoRemovido);
            }
            else{
                throw new IllegalAccessException("Estoque insuficiente para remover" + quantidadeRetirada + "unidades.");
            }
        }
        else{
            throw new ProdutoNaoEncontradoException("Produto" + id + "não encontrado");
        }

    }
}
