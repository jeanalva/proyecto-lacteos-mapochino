package com.empresalacteos.consulta_factura.adapter;

public class UsuarioSuspendido {
	private boolean isOn;

	public boolean isOn() {
		return isOn;
	}

	public void on() {

		isOn = true;
	}

	public void off() {

		isOn = false;
	}
}
