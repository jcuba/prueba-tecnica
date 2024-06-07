package com.prueba.services.products.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.services.products.entity.Productos;
import com.prueba.services.products.exception.ApiException;
import com.prueba.services.products.repository.ProductoRepository;
import com.prueba.services.products.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	@Transactional
	public Productos create(Productos productos) throws ApiException {
		return productoRepository.save(productos);
	}

	@Override
	public List<Productos> getAll() throws ApiException {
		return productoRepository.findAll();
	}


	@Override
	public void deleteById(Long idProducto) throws ApiException {
		productoRepository.deleteById(idProducto);
		
	}

	@Override
	public Productos getProducto(Long idProducto) throws ApiException {
		return productoRepository.findById(idProducto).orElse(null);
	}

}
