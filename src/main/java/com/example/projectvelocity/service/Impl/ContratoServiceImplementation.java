package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projectvelocity.repository.ContratoRepository;
import com.example.projectvelocity.service.ContratoService;

import java.util.List;

@Service
public class ContratoServiceImplementation implements ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Override
    public Long saveContrato(Contrato contrato) {
        Long id = contratoRepository.save(contrato).getId();
        return id;
    }

    @Override
    public void updateContrato(Contrato contrato) {
        contratoRepository.save(contrato);
    }

    @Override
    public void deleteContrato(Long id) {
        Contrato contrato = getOneContrato(id);
        contratoRepository.delete(contrato);
    }

    @Override
    public Contrato getOneContrato(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Contrato  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return contrato;
    }

    @Override
    public List<Contrato> getAllContrato() {
        List<Contrato> list = contratoRepository.findAll();
        return list;
    }

    @Override
    public boolean isContratoExist(Long id) {
        if (contratoRepository.existsById(id)){
            return true;
        }
        return false;
    }


}
