package com.empresalacteos.consulta_factura.bridge;

public class Procesado implements IElaborar {
	public Procesado() {
	}

	// --------------------------
	@Override
	public void procesar() {
		// Operaciones necesarias
		// ...
		System.out.println("\tYogurt procesado elaborado");
	}
}
