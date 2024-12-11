package com.empresalacteos.consulta_factura.composite;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Pedido extends ProductoCompuesto {
	
	private String cliente; // nombre del cliente

	public Pedido(String cliente) {
		super();
		this.cliente = cliente;
	}

	@Override
	public void addProducto(IPrecio producto) {
		super.addProducto(producto);
	}
	
	@Override
	public void removeProducto(IPrecio producto) {
		super.removeProducto(producto);
	}
	
	public void estableceCantidad(IPrecio producto, int cantidadFinal) {
		if(producto instanceof ProductoUnitario) {
			((ProductoUnitario) super.getProductos().get(super.getProductos().indexOf(producto))).setCantidad(cantidadFinal);
			
		}
	}
	
	public void establecePeso(IPrecio producto, double pesoFInal) {
		if(producto instanceof ProductoPeso) {
			((ProductoPeso) super.getProductos().get(super.getProductos().indexOf(producto))).setPeso(pesoFInal);
			
		}
	}
	

}
