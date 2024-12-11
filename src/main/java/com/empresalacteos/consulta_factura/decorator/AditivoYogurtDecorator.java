package com.empresalacteos.consulta_factura.decorator;

public class AditivoYogurtDecorator extends YogurtDecorator {

	public AditivoYogurtDecorator(Yogurt yogurt) {
		super(yogurt);
	}

	@Override
	public void crearFuncionalidad() {
		super.crearFuncionalidad();
		System.out.print(" y agregados (Yogurt con aditivos): ");
		this.addMezcla();
		this.addEsterilizado();
	}

	private void addMezcla() {
		System.out.print(" Mezcla");
	}

	private void addEsterilizado() {
		System.out.print(" Esterilizado ");
	}
}
