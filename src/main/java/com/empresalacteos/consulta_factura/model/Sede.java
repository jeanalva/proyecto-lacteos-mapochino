package com.empresalacteos.consulta_factura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sede")
public class Sede {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSede;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "denominacion")
	private String denominacion;
}
