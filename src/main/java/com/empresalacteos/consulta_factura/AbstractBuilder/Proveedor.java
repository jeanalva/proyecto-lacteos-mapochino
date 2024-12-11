package com.empresalacteos.consulta_factura.AbstractBuilder;

//clase director
public class Proveedor {
	
	private LecheBuilder lecheBuilder; // 
	
	public void setLecheBuilder(LecheBuilder lb) {
		lecheBuilder=lb;
	}
	
	public Leche getLeche() {
		return lecheBuilder.getLeche();
	}
	
	public void construirLeche() {
		lecheBuilder.crearNuevaLeche();
		lecheBuilder.buildProteina();
		lecheBuilder.buildCalcio();
		lecheBuilder.buildCarbohidrato();
	}

}
