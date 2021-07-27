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
    private FuncionarioRepository planRepository;


    @Override
    public Long saveFuncionario(Funcionario Funcionario) {
        Long id = planRepository.save(Funcionario).getId();
        return id;
    }

    @Override
    public void updateFuncionario(Funcionario Funcionario) {
        planRepository.save(Funcionario);
    }

    @Override
    public void deleteFuncionario(Long id) {
        Funcionario Funcionario = getOneFuncionario(id);
        planRepository.delete(Funcionario);
    }

    @Override
    public Funcionario getOneFuncionario(Long id) {
        Funcionario Funcionario = planRepository.findById(id)
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
        List<Funcionario> list = planRepository.findAll();
        return list;
    }

    @Override
    public boolean isFuncionarioExist(Long id) {
        if (planRepository.existsById(id)){
            return true;
        }
        return false;
    }
}