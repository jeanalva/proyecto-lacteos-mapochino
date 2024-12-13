package com.empresalacteos.consulta_factura.facade;

public class InventarioSevice implements EntregaService {
    @Override
    public void registrado() {
        System.out.println("Inventario actualizado");
    }

    @Override
    public void noRegistrado() {
        System.out.println("Inventario no actualizado");
    }
}