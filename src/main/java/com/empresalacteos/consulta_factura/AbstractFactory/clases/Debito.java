package com.empresalacteos.consulta_factura.AbstractFactory.clases;

import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.Pago;

public class Debito implements Pago {
	//atributo codigo
	private int codigo;

	public int generarCodigo() { // metodo que genera aletoriamente un codigo pata el tipo de debito
		int codigoDebito = (int) (Math.random() * 9999);
		return codigoDebito;
	}

	public int getCodigo() { // metodo get
		return codigo;
	}

	public void setCodigo(int codigo) { //metodo set
		this.codigo = codigo;
	}

	@Override
	public void codigoDePago() { // metodo que imprime el codigo generado para tipo de comprobante debito
		System.out.println("El Codigo de pago a debito es : " + getCodigo());
	}
}