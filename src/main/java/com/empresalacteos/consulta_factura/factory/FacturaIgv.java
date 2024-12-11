package com.empresalacteos.consulta_factura.factory;

public class FacturaIgv extends Factura {
	
	@Override
	public double getImporteIgv() {
		return getImporte() * 1.21;
	}
	
}
