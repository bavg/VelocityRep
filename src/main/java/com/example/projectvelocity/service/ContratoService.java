package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Contrato;

import java.util.List;

public interface ContratoService {

    Long saveContrato(Contrato contrato);

    void updateContrato(Contrato contrato, Long id);

    void deleteContrato(Long id);

    Contrato getOneContrato(Long id);

    List<Contrato> getAllContrato();

    boolean isContratoExist(Long id);
}
