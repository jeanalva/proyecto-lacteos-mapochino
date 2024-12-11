package com.empresalacteos.consulta_factura.command;

public class Receptor {
	public Receptor() {
	}

	// -----------------------
	public void accion(String accion) {
		if (accion.compareTo("ABRIR") == 0) {
			System.out.println("Abrir documento");
		} else if (accion.compareTo("IMPRIMIR") == 0) {
			System.out.println("Imprimir documento");
		} else if (accion.compareTo("SALIR") == 0) {
			System.out.println("Salir del programa");
		} else {
			System.out.println("Opción no válida");
		}
	}
}
