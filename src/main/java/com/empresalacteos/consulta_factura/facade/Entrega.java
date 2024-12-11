package com.empresalacteos.consulta_factura.facade;

import java.util.List;

public class Entrega {
	
	private final AlimentosDerivados derivados;
    private final AlimentosProcesados procesados;
    private final List<EntregaService> entregaServices;

    public Entrega(AlimentosDerivados derivados, AlimentosProcesados procesados, List<EntregaService> entregaServices) { // metodo constructor de la clase entrega
        this.derivados = derivados;
        this.procesados = procesados;
        this.entregaServices = entregaServices;
    }

    public AlimentosProcesados getDerivados() {
        return procesados;
    }

    public AlimentosDerivados getProceDerivados() {
        return derivados;
    }

    public List<EntregaService> getEntregaServices() {
        return entregaServices;
    }
    

}
