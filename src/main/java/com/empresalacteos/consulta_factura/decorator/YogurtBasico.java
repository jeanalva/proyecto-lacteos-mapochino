package com.empresalacteos.consulta_factura.decorator;

public class YogurtBasico implements Yogurt {

	@Override
	public void crearFuncionalidad() {
		System.out.println(" Yogurt basico con: ");
		this.addLeche();
	}

	private void addLeche() {
		System.out.print(" Leche");
	}
}
