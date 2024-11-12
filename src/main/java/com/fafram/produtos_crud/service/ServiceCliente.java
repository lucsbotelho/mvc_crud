package com.fafram.produtos_crud.service;
import com.fafram.produtos_crud.model.Cliente;
import com.fafram.produtos_crud.repository.ClienteRepository;
import com.fafram.produtos_crud.utils.ClienteNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCliente implements InterfaceCliente {

    @Autowired
    private ClienteRepository cliente;

    @Override
    public Cliente salvarCliente(Cliente client) {
        return cliente.save(client);
    }

    @Override
    public Cliente procurarPorId(Long id) {
        Optional<Cliente> listaCliente = cliente.findById(id);
        if (listaCliente.isPresent()){
            return listaCliente.get();
        } else{
            throw new ClienteNaoEncontradoException("Cliente" + id + "não encontrado");
        }
    }

    @Override
    public List<Cliente> verTodosClientes() {
        return cliente.findAll();
    }

    @Override
    public void atualizarCliente(Cliente client) {
        cliente.save(client);
    }

    @Override
    public void deletarCliente(Long id) {
        cliente.delete(procurarPorId(id));
    }
}
