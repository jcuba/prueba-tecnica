package com.prueba.services.products.service;

import java.util.List;
import java.util.Optional;

import com.prueba.services.products.entity.Productos;


public interface ProductoService {
	List<Productos> list();
	Optional<Productos> getOne(Long idProducto);
	Optional<Productos> getByNombre(String nombre);
	void save(Productos producto);
	void delete(Long idProducto);
	boolean existsById(Long idProducto);
	boolean existsByNombre(String nombre);
}
