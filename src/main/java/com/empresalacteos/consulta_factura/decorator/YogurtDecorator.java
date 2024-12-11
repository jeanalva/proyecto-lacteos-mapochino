package com.empresalacteos.consulta_factura.decorator;

public abstract class YogurtDecorator implements Yogurt {

	private final Yogurt yogurt; // atributo de tipo yogurt

	public YogurtDecorator(Yogurt yogurt) {
		this.yogurt = yogurt;
	}

	@Override
	public void crearFuncionalidad() {
		this.yogurt.crearFuncionalidad();
	}
}
