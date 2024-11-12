package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.VendaProduto;

import java.util.List;

public interface InterfaceVendaProduto {
    public VendaProduto salvarVendaProduto(VendaProduto vendaDoProduto);
    public VendaProduto procurarPorId(Long id);
    public List<VendaProduto> verTodasVendaDoProduto();
    public void atualizarvendaDoProduto(VendaProduto vendaDoProduto);
    public void deletarvendaDoProduto(Long id);

}
