package com.empresalacteos.consulta_factura.state;

public class Usuario {

	private State state;
	private boolean buying = false;
	private boolean enable = false;

	public Usuario() {
		this.state = new ActivoState(this);
		setEnable(true);
		setBuying(true);
	}

	public String startBuy() {
		return "Buying t-shirt";
	}

	public void changeState(State state) {
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

	public void setBuying(boolean buying) {
		this.buying = buying;
	}

	public boolean isBuying() {
		return buying;
	}

}