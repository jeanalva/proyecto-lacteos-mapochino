package com.empresalacteos.consulta_factura.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresalacteos.consulta_factura.dto.FiltroBusquedaEspecificoRequestDto;
import com.empresalacteos.consulta_factura.dto.FiltroConsultorRequestDto;
import com.empresalacteos.consulta_factura.dto.registrarComprobanteDto;
import com.empresalacteos.consulta_factura.model.Movimiento;
import com.empresalacteos.consulta_factura.model.MovimientoDetalle;
import com.empresalacteos.consulta_factura.model.TipoCarga;
import com.empresalacteos.consulta_factura.service.IMovimientoDetalleService;
import com.empresalacteos.consulta_factura.service.IMovimientoService;

@RestController
@RequestMapping("/movimientos-detalles")
public class MovimientoDetalleController {

	@Autowired
	private IMovimientoDetalleService movimientoDetalleService;
	@Autowired
	private IMovimientoService movimientoService;

	@GetMapping
	public List<MovimientoDetalle> listar() {
		return movimientoDetalleService.listar();
	}

	@GetMapping("/{id}")
	public MovimientoDetalle listarPorId(@PathVariable("id") Integer id) {
		return movimientoDetalleService.listarPorId(id);
	}

	@PostMapping
	public MovimientoDetalle registrar(@RequestBody registrarComprobanteDto dto) {
		MovimientoDetalle movimientoDetalle = new MovimientoDetalle();
		Movimiento movimiento = new Movimiento();
		try {
			if (dto.getMovimiento().getIdMovimiento() > 0) {
				movimiento = movimientoService.listarPorId(dto.getMovimiento().getIdMovimiento());
				if (movimiento != null) {
					movimiento.setCantidadTotal(movimiento.getCantidadTotal() + 1);
					movimiento.setFechaHoraCarga(LocalDateTime.now(ZoneId.of("America/Lima")));
					movimiento.setSede(dto.getSede());
					TipoCarga tc = new TipoCarga();
					tc.setIdTipoCarga(1);
					movimiento.setTipoCarga(tc);
					movimientoService.modificar(movimiento);

					dto.getMovimientoDetalle().setMovimiento(movimiento);
					movimientoDetalle = movimientoDetalleService.registrar(dto.getMovimientoDetalle());
				}

			} else {
				movimiento.setCantidadTotal(1);
				movimiento.setFechaHoraCarga(LocalDateTime.now(ZoneId.of("America/Lima")));
				movimiento.setSede(dto.getSede());
				movimiento.setUsuario(dto.getUsuario());
				TipoCarga tc = new TipoCarga();
				tc.setIdTipoCarga(1);
				movimiento.setTipoCarga(tc);
				movimiento = movimientoService.registrar(movimiento);

				dto.getMovimientoDetalle().setMovimiento(movimiento);
				movimientoDetalle = movimientoDetalleService.registrar(dto.getMovimientoDetalle());
			}

		} catch (Exception e) {
			throw e;
		}
		return movimientoDetalle;
	}

	@PutMapping
	public MovimientoDetalle modificar(@RequestBody MovimientoDetalle model) {
		return movimientoDetalleService.modificar(model);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		movimientoDetalleService.eliminar(id);
	}

//1. solid (S) (antes)

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






