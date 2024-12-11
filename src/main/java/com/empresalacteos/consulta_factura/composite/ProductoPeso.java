package com.empresalacteos.consulta_factura.composite;

import lombok.Data;

@Data
public class ProductoPeso implements IPrecio {
	private double peso;
	private double precioPorPeso;
	private String nombre;
	private String categoria;
	
	public ProductoPeso(double peso, double precioPorPeso, String nombre, String categoria) { // metodo construtor
		super();
		this.peso = peso;
		this.precioPorPeso = precioPorPeso;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	@Override
	public double getImporteTotal() {
		return getPrecioPorPeso() * getPeso();
	}
	
	

}
