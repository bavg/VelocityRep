package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Facturacion;
import com.example.projectvelocity.repository.FacturacionRepository;
import com.example.projectvelocity.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturacionServiceImplementation implements FacturacionService {

    @Autowired
    private FacturacionRepository facturacionRepository;


    @Override
    public Long saveFacturacion(Facturacion Facturacion) {
        Long id = facturacionRepository.save(Facturacion).getId();
        return id;
    }

    @Override
    public void updateFacturacion(Facturacion facturacion, Long id) {
        Facturacion old = getOneFacturacion(id);
        old.setNumeroFactura(facturacion.getNumeroFactura());
        old.setMonto(facturacion.getMonto());
        old.setFecha(facturacion.getFecha());
        facturacionRepository.save(facturacion);
    }

    @Override
    public void deleteFacturacion(Long id) {
        Facturacion Facturacion = getOneFacturacion(id);
        facturacionRepository.delete(Facturacion);
    }

    @Override
    public Facturacion getOneFacturacion(Long id) {
        Facturacion facturacion = facturacionRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Facturacion  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return facturacion;
    }

    @Override
    public List<Facturacion> getAllFacturacion() {
        List<Facturacion> list = facturacionRepository.findAll();
        return list;
    }

    @Override
    public boolean isFacturacionExist(Long id) {
        if (facturacionRepository.existsById(id)){
            return true;
        }
        return false;
    }
}