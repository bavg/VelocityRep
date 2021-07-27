package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Credencial;

import java.util.List;

public interface CredencialService {

    Long saveCredencial(Credencial credencial);

    void updateCredencial(Credencial credencial);

    void deleteCredencial(Long id);

    Credencial getOneCredencial(Long id);

    List<Credencial> getAllCredencial();

    boolean isCredencialExist(Long id);
}
