package com.empresalacteos.consulta_factura.command;

import java.util.ArrayList;

public class Menu {
	private ArrayList<IMenuItem> aMenu = new ArrayList<IMenuItem>();

	// --------------------------
	public Menu() {
	}

	// --------------------------
	public void add(IMenuItem objMenuItem) {
		this.aMenu.add(objMenuItem);
	}

	// --------------------------
	public IMenuItem get(int nOpcion) {
		return this.aMenu.get(nOpcion);
	}
}