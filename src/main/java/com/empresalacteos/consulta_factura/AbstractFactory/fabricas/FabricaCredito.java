package com.empresalacteos.consulta_factura.AbstractFactory.fabricas;

import com.empresalacteos.consulta_factura.AbstractFactory.clases.Credito;
import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.Pago;
import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.PagoDeCompra;

public class FabricaCredito implements PagoDeCompra {
	@Override
	public Pago crearPago() {
		Credito credito = new Credito();
		credito.setCodigo(credito.generarCodigo());
		System.out.println("Se ha creado un nuevo Objeto de pago a credito  ");
		return credito;
	}
}