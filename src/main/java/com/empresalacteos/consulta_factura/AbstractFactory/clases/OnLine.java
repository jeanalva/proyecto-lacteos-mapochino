package com.empresalacteos.consulta_factura.AbstractFactory.clases;

import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.Pago;

public class OnLine implements Pago {
	
	private int codigo;

	public int generarCodigo() {
		/** Generamos un codigo aleatorio*/
		int codigoTaxi = (int) (Math.random() * 9999);
		return codigoTaxi;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public void codigoDePago() {
		System.out.println("El Codigo de pago online es : " + getCodigo());
	}
}
