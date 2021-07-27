package com.example.projectvelocity.service;

import com.example.projectvelocity.model.OrdenTrabajo;

import java.util.List;

public interface OrdenTrabajoService {

    Long saveOrdenTrabajo(OrdenTrabajo ordenTrabajo);

    void updateOrdenTrabajo(OrdenTrabajo ordenTrabajo);

    void deleteOrdenTrabajo(Long id);

    OrdenTrabajo getOneOrdenTrabajo(Long id);

    List<OrdenTrabajo> getAllOrdenTrabajo();

    boolean isOrdenTrabajoExist(Long id);
}