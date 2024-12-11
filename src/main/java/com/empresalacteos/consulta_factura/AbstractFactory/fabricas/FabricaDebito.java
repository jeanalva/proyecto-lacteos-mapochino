package com.empresalacteos.consulta_factura.AbstractFactory.fabricas;

import com.empresalacteos.consulta_factura.AbstractFactory.clases.Debito;
import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.Pago;
import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.PagoDeCompra;

public class FabricaDebito implements PagoDeCompra {
	public Pago crearPago() {
		Debito debito = new Debito();
		debito.setCodigo(debito.generarCodigo());
		System.out.println("Se ha creado un nuevo Objeto de pago a debito  ");
		return debito;
	}
}
