package com.empresalacteos.consulta_factura.decorator;

public class HomogenizadoYogurtDecorator extends YogurtDecorator {

	public HomogenizadoYogurtDecorator(Yogurt yogurt) {
		super(yogurt);
	}

	@Override
	public void crearFuncionalidad() {
		super.crearFuncionalidad();
		System.out.print(" y mas agregados (Yogurt homogenizado): ");
		this.addEsterilizado();
		this.addInoculado();
		this.addIncubado();
	}

	private void addEsterilizado() {
		System.out.print(" Esterilizado ");
	}

	private void addInoculado() {
		System.out.print(" Inoculado ");
	}

	private void addIncubado() {
		System.out.print(" Incubado ");
	}
}