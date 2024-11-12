package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.Cliente;

import java.util.List;
public interface InterfaceCliente {

    public Cliente salvarCliente(Cliente client);
    public Cliente procurarPorId(Long id);
    public List<Cliente> verTodosClientes();
    public void atualizarCliente(Cliente client);
    public void deletarCliente(Long id);

}
