package com.prueba.services.products.service;

import java.util.List;

import com.prueba.services.products.entity.Productos;
import com.prueba.services.products.exception.ApiException;

public interface ProductoService {
	Productos create(Productos productos) throws ApiException;
	List<Productos> getAll() throws ApiException;
	Productos getProducto(Long idProducto) throws ApiException;
	public void deleteById(Long idProducto) throws ApiException;
	
}
