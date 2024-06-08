package com.prueba.services.products.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.services.products.entity.Productos;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Long>{
    Optional<Productos> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
