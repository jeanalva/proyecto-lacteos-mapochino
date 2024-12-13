package com.empresalacteos.consulta_factura.bridge;

public class ElaborarYogurt extends ElaborarAlimento {
	public ElaborarYogurt(IElaborar implementador) {
		this.setImplementador(implementador);
	}

	// ------------------------
	@Override
	public void obtener() {
		System.out.println("Preparando Yogurt...");
		this.getImplementador().procesar();
	}
}
