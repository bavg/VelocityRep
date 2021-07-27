package com.example.projectvelocity.repository;

import com.example.projectvelocity.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}