package com.empresalacteos.consulta_factura.AbstractBuilder;

public class EnteraLecheBuilder extends LecheBuilder {

	@Override
	public void buildProteina() {
		leche.setProteina("24 %");
	}

	@Override
	public void buildCalcio() {
		leche.setCalcio("11 %");
	}

	@Override
	public void buildCarbohidrato() {
		leche.setCarbohidrato("12 %");
	}

}
