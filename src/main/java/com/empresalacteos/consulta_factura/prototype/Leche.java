package com.empresalacteos.consulta_factura.prototype;

public class Leche extends Producto {

	public String frase;

	public Leche() {
	}

	public Leche(Leche leche) {
		super(leche);
		if (leche != null) {
			this.frase = leche.frase;
		}
	}

	@Override
	public Producto clone() {
		return new Leche(this);
	}

	@Override
	public boolean equals(Object object2) {
		if (!(object2 instanceof Leche) || !super.equals(object2))
			return false;
		Leche leche2 = (Leche) object2;
		return leche2.frase == frase;
	}

}