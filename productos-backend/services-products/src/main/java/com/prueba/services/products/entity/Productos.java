package com.prueba.services.products.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	private String nomProducto;
	private double precio;
	
	

}
