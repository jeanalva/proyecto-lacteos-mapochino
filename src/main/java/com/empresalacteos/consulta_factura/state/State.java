package com.empresalacteos.consulta_factura.state;

public abstract class State {

	Usuario user;

	State(Usuario user) {
		this.user = user;
	}

	public abstract String onActivo();

	public abstract String onDesactivo();

	public abstract String onBloqueado();

	public abstract String onComprando();
}