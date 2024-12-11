package com.empresalacteos.consulta_factura.factory;

public class FacturaIgvReducido extends Factura {
	
	@Override
	public double getImporteIgv() {
		return getImporte() * 1.07;
	}
	
}
