package com.prueba.services.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.services.products.entity.Productos;


public interface ProductoService {
	List<Productos> list();
	Optional<Productos> getOne(Long idProducto);
	Optional<Productos> getByNombre(String nombre);
	void save(Productos producto);
	void delete(Long idProducto);
	
	public Page<Productos> paginas(Pageable pageable);
	
	boolean existsById(Long idProducto);
	boolean existsByNombre(String nombre);
}
