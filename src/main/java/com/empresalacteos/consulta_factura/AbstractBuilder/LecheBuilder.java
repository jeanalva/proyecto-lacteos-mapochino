package com.empresalacteos.consulta_factura.AbstractBuilder;

//abstrac builder
public abstract class LecheBuilder {
	
	//atributo de tipo abstracto
	protected Leche leche;

	public Leche getLeche() { // instancia la clase leche
		return leche;
	}

	public void crearNuevaLeche() { // crea un nuevo objeto de tipo leche
		leche = new Leche();
	}

	public abstract void buildProteina();
	public abstract void buildCalcio();
	public abstract void buildCarbohidrato();
}
