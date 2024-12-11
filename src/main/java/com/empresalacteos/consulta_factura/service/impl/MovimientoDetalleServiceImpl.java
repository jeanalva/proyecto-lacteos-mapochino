package com.empresalacteos.consulta_factura.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresalacteos.consulta_factura.dto.FiltroBusquedaEspecificoRequestDto;
import com.empresalacteos.consulta_factura.dto.FiltroConsultorRequestDto;
import com.empresalacteos.consulta_factura.model.MovimientoDetalle;
import com.empresalacteos.consulta_factura.repo.IMovimientoDetalleRepo;
import com.empresalacteos.consulta_factura.repo.IMovimientoRepo;
import com.empresalacteos.consulta_factura.service.IMovimientoDetalleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovimientoDetalleServiceImpl implements IMovimientoDetalleService {

	@Autowired
	private IMovimientoDetalleRepo movimientoDetalleRepo;

	@Autowired
	private IMovimientoRepo movimientoRepo;

	@Override
	public MovimientoDetalle registrar(MovimientoDetalle model) {
		return movimientoDetalleRepo.save(model);
	}

	@Override
	public MovimientoDetalle modificar(MovimientoDetalle model) {
		return movimientoDetalleRepo.save(model);
	}

	@Override
	public MovimientoDetalle listarPorId(Integer id) {
		Optional<MovimientoDetalle> op = movimientoDetalleRepo.findById(id);
		return op.isPresent() ? op.get() : new MovimientoDetalle();
	}

	@Override
	public List<MovimientoDetalle> listar() {
		return movimientoDetalleRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		movimientoDetalleRepo.deleteById(id);
	}

	@Override
	public List<MovimientoDetalle> listarDetallePorMovimiento(Integer id) {
		return movimientoDetalleRepo.listarDetallePorMovimiento(id);
	}

	@Override
	public List<MovimientoDetalle> listarDetallePorRuc(String ruc) {
		return movimientoDetalleRepo.listarDetallePorRuc(ruc.trim());
	}

	@Override
	public List<MovimientoDetalle> buscarPorfechaTipoYnumero(FiltroConsultorRequestDto filtroDto) {
		List<MovimientoDetalle> listResult = new ArrayList<>();
		String numComprobante;
		if (filtroDto != null) {
			if (filtroDto.getFechaPago() != null) {
				listResult = movimientoDetalleRepo.buscarPorfechaTipoYnumero(filtroDto.getIdTipoComprobante(),
						filtroDto.getNumeroComprobante().trim(), filtroDto.getFechaPago());
			} else {
				if (!filtroDto.getNumeroComprobante().isEmpty()) {
					numComprobante = filtroDto.getNumeroComprobante().trim();
				} else {
					numComprobante = " ";
				}
				listResult = movimientoDetalleRepo.buscarPorTipoYnumero(filtroDto.getIdTipoComprobante(),
						numComprobante);
			}

		}
		return listResult;
	}
	
	@Override
	public List<MovimientoDetalle> buscarEspecifico(FiltroBusquedaEspecificoRequestDto dto) {
		return movimientoDetalleRepo.buscarEspecifico(dto.getIdMovimiento(), dto.getNumeroComprobante());
	}

}
