package com.example.projectvelocity.service.Impl;
import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.EncargadoBodega;
import com.example.projectvelocity.repository.EncargadoBodegaRepository;
import com.example.projectvelocity.service.EncargadoBodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncargadoBodegaServiceImplementation implements EncargadoBodegaService {

    @Autowired
    private EncargadoBodegaRepository encargadoBodegaRepository;

    @Override
    public Long saveEncargadoBodega(EncargadoBodega encargadoBodega){
        Long id = encargadoBodegaRepository.save(encargadoBodega).getId();
        return id;
    }

    @Override
    public void updateEncargadoBodega(EncargadoBodega encargadoBodega){
        encargadoBodegaRepository.save(encargadoBodega);
    }

    @Override
    public void deleteEncargadoBodega(Long id){
        EncargadoBodega encargadoBodega = getOneEncargadoBodega(id);
        encargadoBodegaRepository.delete(encargadoBodega);
    }

    @Override
    public EncargadoBodega getOneEncargadoBodega(Long id){
        EncargadoBodega encargadoBodega = encargadoBodegaRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("EncargadoBodega  '")
                                .append(id)
                                .append("' no existe")
                                .toString()
                ));
        return encargadoBodega;
    }

    @Override
    public List<EncargadoBodega> getAllEncargadoBodega() {
        List<EncargadoBodega> list = encargadoBodegaRepository.findAll();
        return list;
    }

    @Override
    public boolean isEncargadoBodegaExist(Long id){
        if(encargadoBodegaRepository.existsById(id)){
            return true;
        }
        return false;
    }
}