package com.empresalacteos.consulta_factura.state;

public class ComprandoState extends State {

	public ComprandoState(Usuario user) {
		super(user);
		user.setBuying(true);
	}

	@Override
	public String onActive() {
		user.changeState(new ActivoState(user));
		System.out.println("Compra Activa");
		return "Comprar Activado...";
	}

	@Override
	public String onDisable() {
		user.changeState(new DesactivadoState(user));
		System.out.println("Compra desactivada");
		return "Compra desactivada";
	}

	@Override
	public String onLock() {
		user.changeState(new BloqueadoState(user));
		System.out.println("Compra bloqueada");
		return "Compra bloqueada";
	}

	@Override
	public String onBuy() {
		user.changeState(new ComprandoState(user));
		System.out.println("Comprando");
		return "Comprando";
	}
}
