package com.empresalacteos.consulta_factura.state;

public class DesactivadoState extends State {

	public DesactivadoState(Usuario user) {
		super(user);
		user.setComprando(false);
		user.setEnable(false);

	}

	@Override
	public String onActivo() {
		user.cambioState(new ActivoState(user));
		System.out.println("Activo");
		return "Activo...";
	}

	@Override
	public String onDesactivo() {
		user.cambioState(new ActivoState(user));
		System.out.println("Desactivo");
		return "Desactivo...";
	}

	@Override
	public String onBloqueado() {
		if (user.isBuying()) {
			user.cambioState(new ActivoState(user));
			System.out.println("Compra bloqueada");
			return "Compra bloqueada";
		} else {
			return "Desactivo...";
		}
	}

	@Override
	public String onComprando() {
		user.cambioState(new ActivoState(user));
		return "Comprando...";
	}
}
