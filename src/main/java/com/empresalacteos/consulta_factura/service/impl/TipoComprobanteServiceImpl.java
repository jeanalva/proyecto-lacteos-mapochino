package com.empresalacteos.consulta_factura.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresalacteos.consulta_factura.model.TipoComprobante;
import com.empresalacteos.consulta_factura.repo.ITipoComprobanteRepo;
import com.empresalacteos.consulta_factura.service.ITipoComprobanteService;


@Service
public class TipoComprobanteServiceImpl implements ITipoComprobanteService {

	@Autowired
	private ITipoComprobanteRepo tipoComprobanteRepo ;

	@Override
	public TipoComprobante registrar(TipoComprobante model) {
		return tipoComprobanteRepo.save(model);
	}

	@Override
	public TipoComprobante modificar(TipoComprobante model) {
		return tipoComprobanteRepo.save(model);
	}

	@Override
	public TipoComprobante listarPorId(Integer id) {
		Optional<TipoComprobante> op = tipoComprobanteRepo.findById(id);
		return op.isPresent() ? op.get() : new TipoComprobante();
	}

	@Override
	public List<TipoComprobante> listar() {
		return tipoComprobanteRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		tipoComprobanteRepo.deleteById(id);
	}
	
}
