package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Cliente;

import java.util.List;

public interface ClienteService {

    Long saveCliente(Cliente cliente);

    void updateCliente(Cliente cliente);

    void deleteCliente(Long id);

    Cliente getOneCliente(Long id);

    List<Cliente> getAllClientes();

    boolean isClienteExist(Long id);
}
