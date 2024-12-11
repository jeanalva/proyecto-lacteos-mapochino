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
@Table(name = "perfil")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPerfil;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "denominacion")
	private String denominacion;
	
	
	//1. adapter
	private boolean activo;

	public boolean estaActivo() {
		return activo;
	}

	public void activar() {
		activo = true;
	}

	public void desactivar() {
		activo = false;
	}

}
