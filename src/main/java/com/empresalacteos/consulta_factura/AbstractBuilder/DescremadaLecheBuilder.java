package com.empresalacteos.consulta_factura.AbstractBuilder;

//concrete builder
public class DescremadaLecheBuilder extends LecheBuilder {
	
	@Override
	public void buildProteina() {
		leche.setProteina("21 %");
	}

	@Override
	public void buildCalcio() {
		leche.setCalcio("18 %");
	}

	@Override
	public void buildCarbohidrato() {
		leche.setCarbohidrato("14 %");
	}

}
