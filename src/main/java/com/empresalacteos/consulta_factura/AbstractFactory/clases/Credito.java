package com.empresalacteos.consulta_factura.AbstractFactory.clases;

import com.empresalacteos.consulta_factura.AbstractFactory.interfaces.Pago;

//clase PAGO
public class Credito implements Pago {

	//atributo codigo
	private int codigo;

	public int generarCodigo() {
		int codigoCredito = (int) (Math.random() * 9999); //un codigo de manera aleatoria
		return codigoCredito;
	}

	public int getCodigo() { // metodo get
		return codigo;
	}

	public void setCodigo(int codigo) { //metodo set
		this.codigo = codigo;
	}

	@Override
	public void codigoDePago() { // metodo imprime el codigo generado aletoriamente
		System.out.println("El Codigo de pago a credito es:" + getCodigo());
	}
}
