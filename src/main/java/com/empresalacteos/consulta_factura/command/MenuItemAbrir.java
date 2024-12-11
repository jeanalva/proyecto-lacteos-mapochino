package com.empresalacteos.consulta_factura.command;

public class MenuItemAbrir implements IMenuItem {
	Receptor r;

	// --------------------------
	public MenuItemAbrir(Receptor r) {
		this.r = r;
	}

	// --------------------------
	@Override
	public void ejecutar() {
		r.accion("ABRIR");
	}
}