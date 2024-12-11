package com.empresalacteos.consulta_factura.AbstractFactory.fabricas;

import com.empresalacteos.consulta_factura.AbstractFactory.clases.OnLine;
import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.Pago;
import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.PagoDeCompra;

public class FabricaOnLine implements PagoDeCompra {
	@Override
	public Pago crearPago() {
		OnLine enLinea = new OnLine();
		enLinea.setCodigo(enLinea.generarCodigo());
		System.out.println("Se ha creado un nuevo Objeto para pago en linea  ");
		return enLinea;
	}
}