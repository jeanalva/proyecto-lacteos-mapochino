package com.empresalacteos.consulta_factura.facade;

import java.util.Arrays;
import java.util.List;

public class EntregaFacade {
	public Entrega entregaExitosa() {

        AlimentosDerivados derivados = new AlimentosDerivados(); // instanciar un objeto de la clase alimentos derivados
        derivados.entregado(); 

        AlimentosProcesados procesados = new AlimentosProcesados(); // instanciar un objeto de la clase alimentos procesados
        procesados.entregado();

        EntregaService venta = new VentaService();
        venta.registrado();

        EntregaService inventario = new InventarioSevice();
        inventario.registrado();

        List<EntregaService> entregaServices = Arrays.asList(venta, inventario); //crea una lista de la venta y actualizacion del inventario
 
        Entrega entrega = new Entrega(derivados, procesados, entregaServices);

        return entrega;
    }

    public void entregaIncompleto(Entrega entrega) {

        for(EntregaService service :entrega.getEntregaServices()) {
            service.registrado();
        }
        entrega.getDerivados().noEntregado();;
        entrega.getProceDerivados().noEntregado();
    }
}
