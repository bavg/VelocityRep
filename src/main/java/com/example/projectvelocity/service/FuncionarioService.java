package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    Long saveFuncionario(Funcionario funcionario);

    void updateFuncionario(Funcionario funcionario, Long id);

    void deleteFuncionario(Long id);

    Funcionario getOneFuncionario(Long id);

    List<Funcionario> getAllFuncionario();

    boolean isFuncionarioExist(Long id);
}