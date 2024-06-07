package com.prueba.services.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.services.products.dto.Mensaje;
import com.prueba.services.products.entity.Productos;
import com.prueba.services.products.exception.ApiException;
import com.prueba.services.products.service.impl.ProductoServiceImpl;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductosController {
	
	@Autowired
	public ProductoServiceImpl productoService;
	
    @GetMapping("/list")
    public ResponseEntity<List<Productos>> list() throws ApiException {
    	List<Productos> list = productoService.getAll();
		return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Productos productos) throws ApiException {
		
		productoService.create(productos);
    
		return new ResponseEntity(new Mensaje("El producto " + productos.getIdProducto() + " fue creado de manera correcta"), HttpStatus.CREATED);
    }
    
    @PutMapping("/editar/{idProducto}")
    public ResponseEntity<?> update(@PathVariable("idProducto") long idProducto, @RequestBody Productos updateProductos) throws ApiException {
		Productos productoDB = productoService.getProducto(idProducto);
		
		productoDB.setNomProducto(updateProductos.getNomProducto());
		productoDB.setPrecio(updateProductos.getPrecio());
		
		productoService.create(productoDB);
		
		return new ResponseEntity(new Mensaje("El producto " + productoDB.getIdProducto() + " fue actualizado de manera correcta"), HttpStatus.OK);
		
    }
    
    
    @DeleteMapping("/eliminar/{idProducto}")
    public ResponseEntity delete(@PathVariable Long idProducto) throws ApiException{
        
        	productoService.deleteById(idProducto);
        
        
        return new ResponseEntity(new Mensaje("El producto fue eliminado de manera correcta"), HttpStatus.OK);
    }
    
}
