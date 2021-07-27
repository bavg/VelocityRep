package com.example.projectvelocity.service.Impl;

import com.example.projectvelocity.exception.VelocityException;
import com.example.projectvelocity.model.Producto;
import com.example.projectvelocity.repository.ProductoRepository;
import com.example.projectvelocity.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplementation implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public Long saveProducto(Producto Producto) {
        Long id = productoRepository.save(Producto).getId();
        return id;
    }

    @Override
    public void updateProducto(Producto Producto) {
        productoRepository.save(Producto);
    }

    @Override
    public void deleteProducto(Long id) {
        Producto Producto = getOneProducto(id);
        productoRepository.delete(Producto);
    }

    @Override
    public Producto getOneProducto(Long id) {
        Producto Producto = productoRepository.findById(id)
                .orElseThrow(()->new VelocityException(
                        new StringBuffer().append("Producto  '")
                                .append(id)
                                .append("' no existe")
                                .toString())
                );
        return Producto;
    }

    @Override
    public List<Producto> getAllProducto() {
        List<Producto> list = productoRepository.findAll();
        return list;
    }

    @Override
    public boolean isProductoExist(Long id) {
        if (productoRepository.existsById(id)){
            return true;
        }
        return false;
    }
}