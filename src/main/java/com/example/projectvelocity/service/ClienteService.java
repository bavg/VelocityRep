package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Cliente;

import java.util.List;

public interface ClienteService {

    Long saveCliente(Cliente cliente);

    void updateCliente(Cliente cliente, Long id);

    void deleteCliente(Long id);

    Cliente getOneCliente(Long id);

    List<Cliente> getAllCliente();

    boolean isClienteExist(Long id);
}
