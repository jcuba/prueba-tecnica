package com.prueba.services.products.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.services.products.entity.Productos;
import com.prueba.services.products.repository.ProductoRepository;
import com.prueba.services.products.service.ProductoService;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Productos> list() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Productos> getOne(Long idProducto) {
		return productoRepository.findById(idProducto);
	}

	@Override
	public Optional<Productos> getByNombre(String nombre) {
		return productoRepository.findByNombre(nombre);
	}

	@Override
	public void save(Productos producto) {
		productoRepository.save(producto);
	}

	@Override
	public void delete(Long idProducto) {
		productoRepository.deleteById(idProducto);
	}

	@Override
	public boolean existsById(Long idProducto) {
		return productoRepository.existsById(idProducto);
	}

	@Override
	public boolean existsByNombre(String nombre) {
		return productoRepository.existsByNombre(nombre);
	}

	

}
