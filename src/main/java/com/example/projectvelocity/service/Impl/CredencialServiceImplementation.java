package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Credencial;
import com.example.projectvelocity.repository.CredencialRepository;
import com.example.projectvelocity.service.CredencialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredencialServiceImplementation implements CredencialService {

    @Autowired
    private CredencialRepository credencialRepository;

    @Override
    public Long saveCredencial(Credencial credencial){
        Long id = credencialRepository.save(credencial).getId();
        return id;
    }

    @Override
    public void updateCredencial(Credencial credencial){
        credencialRepository.save(credencial);
    }

    @Override
    public void deleteCredencial(Long id){
        Credencial credencial = getOneCredencial(id);
        credencialRepository.delete(credencial);
    }

    @Override
    public Credencial getOneCredencial(Long id){
        Credencial credencial = credencialRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Credencial  '")
                                .append(id)
                                .append("' no existe")
                                .toString()
                ));
        return credencial;
    }

    @Override
    public List<Credencial> getAllCredencial() {
        List<Credencial> list = credencialRepository.findAll();
        return list;
    }

    @Override
    public boolean isCredencialExist(Long id){
        if(credencialRepository.existsById(id)){
            return true;
        }
        return false;
    }
}