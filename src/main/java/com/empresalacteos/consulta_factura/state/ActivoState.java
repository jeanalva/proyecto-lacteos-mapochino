package com.empresalacteos.consulta_factura.state;

public class ActivoState extends State {

	public ActivoState(Usuario user) {
		super(user);
	}

	@Override
	public String onActivo() {
		user.cambioState(new ComprandoState(user));
		System.out.println("Activado");
		return "Activado ...";
	}

	@Override
	public String onDesactivo() {
		user.cambioState(new DesactivadoState(user));
		System.out.println("Desactivo");
		return "Desactivo...";

	}

	@Override
	public String onBloqueado() {
		user.cambioState(new BloqueadoState(user));
		System.out.println("Bloqueado");
		return "Bloqueado...";
	}

	@Override
	public String onComprando() {
		String action = user.iniciarCompra();
		user.cambioState(new ComprandoState(user));
		return action;
	}
}