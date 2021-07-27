package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.OrdenTrabajo;
import com.example.projectvelocity.repository.OrdenTrabajoRepository;
import com.example.projectvelocity.service.OrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenTrabajoServiceImplementation implements OrdenTrabajoService {

    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;


    @Override
    public Long saveOrdenTrabajo(OrdenTrabajo OrdenTrabajo) {
        Long id = ordenTrabajoRepository.save(OrdenTrabajo).getId();
        return id;
    }

    @Override
    public void updateOrdenTrabajo(OrdenTrabajo OrdenTrabajo) {
        ordenTrabajoRepository.save(OrdenTrabajo);
    }

    @Override
    public void deleteOrdenTrabajo(Long id) {
        OrdenTrabajo OrdenTrabajo = getOneOrdenTrabajo(id);
        ordenTrabajoRepository.delete(OrdenTrabajo);
    }

    @Override
    public OrdenTrabajo getOneOrdenTrabajo(Long id) {
        OrdenTrabajo OrdenTrabajo = ordenTrabajoRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("OrdenTrabajo  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return OrdenTrabajo;
    }

    @Override
    public List<OrdenTrabajo> getAllOrdenTrabajo() {
        List<OrdenTrabajo> list = ordenTrabajoRepository.findAll();
        return list;
    }

    @Override
    public boolean isOrdenTrabajoExist(Long id) {
        if (ordenTrabajoRepository.existsById(id)){
            return true;
        }
        return false;
    }
}