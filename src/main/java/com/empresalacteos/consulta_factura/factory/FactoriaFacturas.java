package com.empresalacteos.consulta_factura.factory;

public class FactoriaFacturas {

	public static Factura getFactura(String tipo) {
		if (tipo.equals("igv")) {
			return new FacturaIgv();
		} else {
			return new FacturaIgvReducido();
		}
	}
}