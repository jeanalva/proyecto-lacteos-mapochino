package com.empresalacteos.consulta_factura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "unidad_operativa")
public class UnidadOperativa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUnidadOperativa;
	
	@Column(name = "denominacion")
	private String denominacion;
	
	@Column(name = "id_sede")
	private Integer idSede;
}
