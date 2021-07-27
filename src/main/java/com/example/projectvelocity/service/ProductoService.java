package com.example.projectvelocity.service;

import com.example.projectvelocity.model.Producto;

import java.util.List;

public interface ProductoService {

    Long saveProducto(Producto producto);

    void updateProducto(Producto producto);

    void deleteProducto(Long id);

    Producto getOneProducto(Long id);

    List<Producto> getAllProducto();

    boolean isProductoExist(Long id);
}