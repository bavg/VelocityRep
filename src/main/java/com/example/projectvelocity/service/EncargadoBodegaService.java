package com.example.projectvelocity.service;

import com.example.projectvelocity.model.EncargadoBodega;

import java.util.List;

public interface EncargadoBodegaService {

    Long saveEncargadoBodega(EncargadoBodega encargadoBodega);

    void updateEncargadoBodega(EncargadoBodega encargadoBodega);

    void deleteEncargadoBodega(Long id);

    EncargadoBodega getOneEncargadoBodega(Long id);

    List<EncargadoBodega> getAllEncargadoBodega();

    boolean isEncargadoBodegaExist(Long id);
}