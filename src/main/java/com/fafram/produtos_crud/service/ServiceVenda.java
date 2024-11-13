package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.Venda;
import com.fafram.produtos_crud.repository.VendaRepository;
import com.fafram.produtos_crud.utils.VendaDoProdutoNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceVenda implements InterfaceVendas{

    @Autowired
    private VendaRepository venda;

    @Override
    public Venda salvarVenda(Venda vendas) {
        return venda.save(vendas);
    }

    @Override
    public Venda procurarPorId(Long id) {
        Optional<Venda> listaDeVenda = venda.findById(id);
        if(listaDeVenda.isPresent()){
            return listaDeVenda.get();
        }
        else{
            throw new VendaDoProdutoNaoEncontrada("Venda" + id + "não encontrada");
        }
    }

    @Override
    public List<Venda> verTodasVendas() {
        return venda.findAll();
    }

    @Override
    public void atualizarVendas(Venda vendas) {
        venda.save(vendas);
    }

    @Override
    public void deletarVendas(Long id) {
        venda.delete(procurarPorId(id));
    }
}
