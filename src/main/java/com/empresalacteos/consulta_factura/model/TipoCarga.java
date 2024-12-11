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
@Table(name = "tipo_carga")
public class TipoCarga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoCarga;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "denominacion")
	private String denominacion;
}
