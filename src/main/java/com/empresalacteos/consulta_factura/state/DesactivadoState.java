package com.empresalacteos.consulta_factura.state;

public class DesactivadoState extends State {

	public DesactivadoState(Usuario user) {
		super(user);
		user.setBuying(false);
		user.setEnable(false);

	}

	@Override
	public String onActive() {
		user.changeState(new ActivoState(user));
		System.out.println("Desactivado");
		return "Desactivado...";
	}

	@Override
	public String onLock() {
		user.changeState(new ActivoState(user));
		System.out.println("Desactivado bloqueado");
		return "Desactivado bloqueado...";
	}

	@Override
	public String onDisable() {
		if (user.isBuying()) {
			user.changeState(new ActivoState(user));
			System.out.println("Compra paralizada");
			return "Compra paralizada";
		} else {
			return "Desactivado...";
		}
	}

	@Override
	public String onBuy() {
		user.changeState(new ActivoState(user));
		return "Disabled temporarily...";
	}
}
