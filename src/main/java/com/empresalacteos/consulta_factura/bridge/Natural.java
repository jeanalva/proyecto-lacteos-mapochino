package com.empresalacteos.consulta_factura.bridge;

public class Natural implements IElaborar {
	public Natural() {
	}

	// --------------------------
	@Override
	public void procesar() {
		// Operaciones necesarias
		// ...
		System.out.println("\tYogurt natural elaborado");
	}
}
