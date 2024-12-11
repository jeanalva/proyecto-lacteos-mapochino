package com.empresalacteos.consulta_factura.service;

import java.util.List;

import com.empresalacteos.consulta_factura.model.Movimiento;

public interface IMovimientoService extends ICRUD<Movimiento> {
	
	List<Movimiento> listarMovimientoPorUsuario(Integer id);
	
	//5. Solid (D) parted 1
	public abstract void calculoTotalDeComprobantes();
}
