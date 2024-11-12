package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.Venda;


import java.util.List;

public interface InterfaceVendas {
    public Venda salvarVenda(Venda vendas);
    public Venda procurarPorId(Long id);
    public List<Venda> verTodasVendas();
    public void atualizarVendas(Venda vendas);
    public void deletarVendas(Long id);
}
