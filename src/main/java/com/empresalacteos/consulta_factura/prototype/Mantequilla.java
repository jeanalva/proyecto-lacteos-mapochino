package com.empresalacteos.consulta_factura.prototype;

public class Mantequilla extends Producto {

	public Boolean flexibilidad;

	public Mantequilla() {
	}

	public Mantequilla(Mantequilla mantequilla) {
		super(mantequilla);
		if (mantequilla != null) {
			this.flexibilidad = mantequilla.flexibilidad;
		}
	}

	@Override
	public Producto clone() {
		return new Mantequilla(this);
	}

	@Override
	public boolean equals(Object object2) {
		if (!(object2 instanceof Mantequilla) || !super.equals(object2))
			return false;
		Mantequilla mantequilla2 = (Mantequilla) object2;
		return mantequilla2.flexibilidad == flexibilidad;
	}
}