package com.example.projectvelocity.repository;

import com.example.projectvelocity.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
