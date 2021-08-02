package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Funcionario;
import com.example.projectvelocity.repository.FuncionarioRepository;
import com.example.projectvelocity.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImplementation implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @Override
    public Long saveFuncionario(Funcionario Funcionario) {
        Long id = funcionarioRepository.save(Funcionario).getId();
        return id;
    }

    @Override
    public void updateFuncionario(Funcionario funcionario, Long id) {
        Funcionario old = getOneFuncionario(id);
        old.setNombre(funcionario.getNombre());
        old.setApellido(funcionario.getApellido());
        old.setCorreo(funcionario.getCorreo());
        old.setDireccion(funcionario.getDireccion());
        old.setFechaNacimiento(funcionario.getFechaNacimiento());
        old.setRut(funcionario.getRut());
        old.setTelefono(funcionario.getTelefono());
        old.setUsuario(funcionario.getUsuario());
        old.setContrasena(funcionario.getContrasena());
        old.setRol(funcionario.getRol());
        old.setContratos(funcionario.getContratos());
        funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteFuncionario(Long id) {
        Funcionario Funcionario = getOneFuncionario(id);
        funcionarioRepository.delete(Funcionario);
    }

    @Override
    public Funcionario getOneFuncionario(Long id) {
        Funcionario Funcionario = funcionarioRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Funcionario  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return Funcionario;
    }

    @Override
    public List<Funcionario> getAllFuncionario() {
        List<Funcionario> list = funcionarioRepository.findAll();
        return list;
    }

    @Override
    public boolean isFuncionarioExist(Long id) {
        if (funcionarioRepository.existsById(id)){
            return true;
        }
        return false;
    }
}