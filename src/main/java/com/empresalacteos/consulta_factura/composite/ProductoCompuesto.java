package com.empresalacteos.consulta_factura.composite;

import java.util.ArrayList;
import java.util.Iterator;

import lombok.Data;

@Data
public class ProductoCompuesto implements IPrecio{
	
	private ArrayList<IPrecio> productos; // una lista de producto
	
	public ProductoCompuesto() {
		productos=new ArrayList<IPrecio>(); // cada producto tendra su calculo de precio
	}
	
	public void addProducto(IPrecio precio) { // metodo que agrega producto
		productos.add(precio);
	}
	
	public void removeProducto(IPrecio precio) { // metodo que elimina producto
		productos.remove(precio);
	}
	
	public ArrayList<IPrecio> getProductos(){ //metodo que retorna la lista de productos
		return productos;
	}
	

	@Override
	public double getImporteTotal() {
		double importeTotal=0; // declara una variable de tipo double
		for(Iterator<IPrecio> it=productos.iterator(); it.hasNext();) { // metodo Iterador
			IPrecio iPrecio=it.next();
			importeTotal+=iPrecio.getImporteTotal();
		}
		return importeTotal;
	}

}
