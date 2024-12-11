package com.empresalacteos.consulta_factura.AbstractFactory.fabricas;

import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.Pago;
import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.PagoDeCompra;

public class FabricaDePagos {
	public static void crearFabricaDePagos(PagoDeCompra pagoDeCompra) {
		/** Aplicamos Polimorfismo */
		Pago objeto = pagoDeCompra.crearPago();
		objeto.codigoDePago();
	}
}