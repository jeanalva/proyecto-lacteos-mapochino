package com.empresalacteos.consulta_factura.state;

public class BloqueadoState extends State {

	public BloqueadoState(Usuario user) {
		super(user);
	}

	@Override
	public String onActivo() {
		System.out.println("Activo");
		return "Activo...";
	}

	@Override
	public String onDesactivo() {
		return "Desactivo...";
	}

	@Override
	public String onBloqueado() {
		if (user.isBuying()) {
			user.cambioState(new DesactivadoState(user));
			return "Bloqueado...";
		}
		if (user.getEnable()) {
			user.cambioState(new DesactivadoState(user));
			return "Desactivo...";
		}
		user.cambioState(new ActivoState(user));
		return "Bloqueado...";
	}

	@Override
	public String onComprando() {
		return "Comprando...";
	}
}
