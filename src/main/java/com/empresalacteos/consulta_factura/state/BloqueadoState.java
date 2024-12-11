package com.empresalacteos.consulta_factura.state;

public class BloqueadoState extends State {

	public BloqueadoState(Usuario user) {
		super(user);
	}

	@Override
	public String onActive() {
		System.out.println("Bloqueado");
		return "Bloqueado...";
	}

	@Override
	public String onDisable() {

		return "Bloqueado...";
	}

	@Override
	public String onLock() {

		if (user.isBuying()) {
			user.changeState(new DesactivadoState(user));
			return "Bloqueado...";
		}
		if (user.getEnable()) {
			user.changeState(new DesactivadoState(user));
			return "Desactivado...";
		}
		user.changeState(new ActivoState(user));
		return "Bloqueado...";
	}

	@Override
	public String onBuy() {
		return "Bloqueado...";
	}
}
