package com.empresalacteos.consulta_factura.composite;

import lombok.Data;

@Data
public class ProductoUnitario implements IPrecio {
	//atributos de la clase
	private int cantidad;
	private double precio;
	private String nombre;
	private String categoria;

	public ProductoUnitario(int cantidad, double precio, String nombre, String categoria) { // metodo constructor
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	@Override
	public double getImporteTotal() {
		return getCantidad() * getPrecio();
	}

}
