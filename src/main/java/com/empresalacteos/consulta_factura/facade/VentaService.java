package com.empresalacteos.consulta_factura.facade;

public class VentaService implements EntregaService {
    @Override
    public void registrado() {
        System.out.println("Venta registrada");
    }

    @Override
    public void noRegistrado() {
        System.out.println("Venta no registrado");
    }
}
