package com.empresalacteos.consulta_factura.state;

public class ComprandoState extends State {

	public ComprandoState(Usuario user) {
		super(user);
		user.setComprando(true);
	}

	@Override
	public String onActivo() {
		user.cambioState(new ActivoState(user));
		System.out.println("Compra Activa");
		return "Compra Activa...";
	}

	@Override
	public String onDesactivo() {
		user.cambioState(new DesactivadoState(user));
		System.out.println("Compra Desactiva");
		return "Compra Desactiva";
	}

	@Override
	public String onBloqueado() {
		user.cambioState(new BloqueadoState(user));
		System.out.println("Compra bloqueada");
		return "Compra bloqueada";
	}

	@Override
	public String onComprando() {
		user.cambioState(new ComprandoState(user));
		System.out.println("Comprando");
		return "Comprando";
	}
}
