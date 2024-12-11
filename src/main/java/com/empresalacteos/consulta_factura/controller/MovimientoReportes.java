package com.empresalacteos.consulta_factura.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.empresalacteos.consulta_factura.dto.FiltroBusquedaEspecificoRequestDto;
import com.empresalacteos.consulta_factura.dto.FiltroConsultorRequestDto;
import com.empresalacteos.consulta_factura.model.MovimientoDetalle;
import com.empresalacteos.consulta_factura.service.IMovimientoDetalleService;

public class MovimientoReportes {
	@Autowired
	private IMovimientoDetalleService movimientoDetalleService;
	
	@GetMapping("/movimiento/{id}")
	public List<MovimientoDetalle> listarDetallePorMovimiento(@PathVariable("id") Integer id) {
		return movimientoDetalleService.listarDetallePorMovimiento(id);
	}

	@GetMapping("/num-ruc/{ruc}")
	public List<MovimientoDetalle> listarDetallePorRuc(@PathVariable("ruc") String ruc) {
		return movimientoDetalleService.listarDetallePorRuc(ruc);
	}

	@PostMapping("/busqueda-consultor")
	public List<MovimientoDetalle> buscarPorfechaTipoYnumero(@RequestBody FiltroConsultorRequestDto filtroDto) {
		List<MovimientoDetalle> movimientoDetalles = new ArrayList<>();
		if (filtroDto != null) {
			movimientoDetalles = movimientoDetalleService.buscarPorfechaTipoYnumero(filtroDto);
		}
		return movimientoDetalles;
	}
	
	@PostMapping("/buscar-especifco")
	public List<MovimientoDetalle> buscarEspecifico(@RequestBody FiltroBusquedaEspecificoRequestDto dto) {
		return movimientoDetalleService.buscarEspecifico(dto);
	}
}




