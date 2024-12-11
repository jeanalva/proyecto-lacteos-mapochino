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
@Table(name = "cuenta")
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCuenta;
	
	@Column(name = "usuario")
	private String usuario;

	@Column(name = "saldo_inicial")
	private double saldoInicial;
	
	public Cuenta(Integer idCuenta, String usuario, double saldoInicial) {
		this.idCuenta = idCuenta;
		this.usuario = usuario;
		this.saldoInicial = saldoInicial;
	}

	
	
}
