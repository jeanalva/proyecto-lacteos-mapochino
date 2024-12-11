package com.empresalacteos.consulta_factura.service;

import java.util.List;

import com.empresalacteos.consulta_factura.dto.FiltroBusquedaEspecificoRequestDto;
import com.empresalacteos.consulta_factura.dto.FiltroConsultorRequestDto;
import com.empresalacteos.consulta_factura.model.MovimientoDetalle;


//3. Solid (L) Liskov: la clase derivada no rompe el comportamiento de la clase base.

public interface IMovimientoDetalleService extends ICRUD<MovimientoDetalle> {

	List<MovimientoDetalle> listarDetallePorMovimiento(Integer id);
	
	List<MovimientoDetalle> listarDetallePorRuc(String ruc);
	
	List<MovimientoDetalle> buscarPorfechaTipoYnumero(FiltroConsultorRequestDto dto);
	
	List<MovimientoDetalle> buscarEspecifico(FiltroBusquedaEspecificoRequestDto dto);
	
}



















