package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.Produto;
import java.util.List;
public interface InterfaceServiceProduto {

    public Produto salvarProduto(Produto product);
    public Produto procurarPorId(Long id);
    public List<Produto> verTodosProdutos();
    public void atualizarProdutos(Produto product);
    public void deletarProdutos(Long id);
    public void adicionarEstoque(Long id, int quantidadeAdicionada);
    public void removerDoEstoque(Long id, int quantidadeRemovida) throws IllegalAccessException;
}
