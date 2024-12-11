package com.empresalacteos.consulta_factura.state;

public abstract class State {

	Usuario user;

	State(Usuario user) {
		this.user = user;
	}

	public abstract String onActive();

	public abstract String onDisable();

	public abstract String onLock();

	public abstract String onBuy();
}