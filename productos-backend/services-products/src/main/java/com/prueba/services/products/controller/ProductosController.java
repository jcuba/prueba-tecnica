package com.prueba.services.products.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.prueba.services.products.dto.ProductoDto;
import com.prueba.services.products.entity.Productos;
import com.prueba.services.products.service.impl.ProductoServiceImpl;


@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductosController {

	@Autowired
	public ProductoServiceImpl productoService;

	@GetMapping("/lista")
    public ResponseEntity<List<Productos>> list(){
        List<Productos> list = productoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Productos> getById(@PathVariable("id") Long idProducto){
        if(!productoService.existsById(idProducto))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Productos producto = productoService.getOne(idProducto).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Productos> getByNombre(@PathVariable("nombre") String nombre){
        if(!productoService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Productos producto = productoService.getByNombre(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        
        if(productoService.existsByNombre(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        Productos producto = new Productos(productoDto.getNombre(), productoDto.getPrecio());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long idProducto, @RequestBody ProductoDto productoDto){
        if(!productoService.existsById(idProducto))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getIdProducto() != idProducto)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Productos producto = productoService.getOne(idProducto).get();
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long idProducto){
        if(!productoService.existsById(idProducto))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        productoService.delete(idProducto);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

}
