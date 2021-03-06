package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Cliente;
import com.example.projectvelocity.repository.ClienteRepository;
import com.example.projectvelocity.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplementation implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Long saveCliente(Cliente cliente){
        Long id = clienteRepository.save(cliente).getId();
        return id;
    }

    @Override
    public void updateCliente(Cliente cliente, Long id){
        Cliente old = getOneCliente(id);
        old.setApellido(cliente.getApellido());
        old.setCorreo(cliente.getCorreo());
        old.setDireccion(cliente.getDireccion());
        old.setNombre(cliente.getNombre());
        old.setRol(cliente.getRol());
        old.setRut(cliente.getRut());
        old.setUsername(cliente.getUsername());
        old.setPassword(cliente.getPassword());
        old.setFechaNacimiento(cliente.getFechaNacimiento());
        old.setTelefono(cliente.getTelefono());
        old.setContratos(cliente.getContratos());
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id){
        Cliente cliente = getOneCliente(id);
        clienteRepository.delete(cliente);
    }

    @Override
    public Cliente getOneCliente(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Cliente  '")
                        .append(id)
                        .append("' no existe")
                        .toString()
                ));
        return cliente;
    }

    @Override
    public List<Cliente> getAllCliente() {
        List<Cliente> list = clienteRepository.findAll();
        return list;
    }

    @Override
    public boolean isClienteExist(Long id){
        if(clienteRepository.existsById(id)){
            return true;
        }
        return false;
    }
}
