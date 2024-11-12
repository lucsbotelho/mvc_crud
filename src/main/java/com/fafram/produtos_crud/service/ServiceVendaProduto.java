package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.VendaProduto;
import com.fafram.produtos_crud.repository.VendaProdutoRepository;
import com.fafram.produtos_crud.utils.VendaDoProdutoNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServiceVendaProduto implements InterfaceVendaProduto{

    @Autowired
    private VendaProdutoRepository vendaProdutos;

    @Override
    public VendaProduto salvarVendaProduto(VendaProduto vendaDoProduto) {
        return vendaProdutos.save(vendaDoProduto);
    }

    @Override
    public VendaProduto procurarPorId(Long id) {
        Optional<VendaProduto> listaDeVendaDeProduto = vendaProdutos.findById(id);
        if (listaDeVendaDeProduto.isPresent()){
            return listaDeVendaDeProduto.get();
        } else{
            throw new VendaDoProdutoNaoEncontrada("O processo de venda" + id + "não foi encontrado");
        }
    }

    @Override
    public List<VendaProduto> verTodasVendaDoProduto() {
        return vendaProdutos.findAll();
    }

    @Override
    public void atualizarvendaDoProduto(VendaProduto vendaDoProduto) {
        vendaProdutos.save(vendaDoProduto);
    }

    @Override
    public void deletarvendaDoProduto(Long id) {
        vendaProdutos.delete(procurarPorId(id));
    }
}
