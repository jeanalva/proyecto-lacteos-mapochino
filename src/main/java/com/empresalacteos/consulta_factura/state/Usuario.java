package com.empresalacteos.consulta_factura.state;

public class Usuario {

	private State state;
	private boolean comprando = false;
	private boolean enable = false;

	public Usuario() {
		this.state = new ActivoState(this);
		setEnable(true);
		setComprando(true);
	}

	public String iniciarCompra() {
		return "Comprando Productos Lacteos";
	}

	public void cambioState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setComprando(boolean buying) {
		this.comprando = buying;
	}

	public boolean isBuying() {
		return comprando;
	}

}