package com.empresalacteos.consulta_factura.state;

public class ActivoState extends State {

	public ActivoState(Usuario user) {
		super(user);
	}

	@Override
	public String onActive() {
		user.changeState(new ComprandoState(user));
		System.out.println("Activado");
		return "Activado ...";
	}

	@Override
	public String onDisable() {
		user.changeState(new DesactivadoState(user));
		System.out.println("Desctivado");
		return "Desctivado...";

	}

	@Override
	public String onLock() {
		user.changeState(new BloqueadoState(user));
		System.out.println("Bloqueado");
		return "Bloqueado...";
	}

	@Override
	public String onBuy() {
		String action = user.startBuy();
		user.changeState(new ComprandoState(user));
		return action;
	}
}