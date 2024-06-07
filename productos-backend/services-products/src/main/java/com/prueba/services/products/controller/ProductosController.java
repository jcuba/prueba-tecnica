package com.prueba.services.products.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.services.products.entity.Productos;
import com.prueba.services.products.service.impl.ProductoServiceImpl;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductosController {
	
	private static Logger log = LoggerFactory.getLogger(ProductosController.class);
	
	@Autowired
	public ProductoServiceImpl productoService;
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos createProductos(@RequestBody Productos productos) throws Exception{
        log.info("Ejecuta el endpoint crear de Usuarios");
        try {
			Productos product = productoService.create(productos);
			log.info("Se creo el producto de forma correcta");
			return product;
		} catch (Exception e) {
			throw e;
		}
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Productos>> Leer() throws Exception{
    	log.info("Ejecuta el endpoint leer de Usuarios");

        try {
            List<Productos> product = this.productoService.getAll();
            log.info("PRODUCTOS ENCONTRADOS: " + product.size());

            List<Productos> productos = productoService.getAll().stream().map(producto ->{
                return producto;
            }).collect(Collectors.toList());
            if(productos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            log.info("Lista de productos terminada");

            return ResponseEntity.ok(productos);
        }catch(Exception e){
            throw e;
        }
    }

}
