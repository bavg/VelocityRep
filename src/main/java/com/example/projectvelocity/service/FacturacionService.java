package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Facturacion;

import java.util.List;

public interface FacturacionService {

    Long saveFacturacion(Facturacion facturacion);

    void updateFacturacion(Facturacion facturacion, Long id);

    void deleteFacturacion(Long id);

    Facturacion getOneFacturacion(Long id);

    List<Facturacion> getAllFacturacion();

    boolean isFacturacionExist(Long id);
}