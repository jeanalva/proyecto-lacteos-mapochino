package com.empresalacteos.consulta_factura.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresalacteos.consulta_factura.model.TipoCarga;
import com.empresalacteos.consulta_factura.repo.ITipoCargaRepo;
import com.empresalacteos.consulta_factura.service.ITipoCargaService;



@Service
public class TipoCargaServiceImpl implements ITipoCargaService {

	@Autowired
	private ITipoCargaRepo tipoCargaRepo ;

	@Override
	public TipoCarga registrar(TipoCarga model) {
		return tipoCargaRepo.save(model);
	}

	@Override
	public TipoCarga modificar(TipoCarga model) {
		return tipoCargaRepo.save(model);
	}

	@Override
	public TipoCarga listarPorId(Integer id) {
		Optional<TipoCarga> op = tipoCargaRepo.findById(id);
		return op.isPresent() ? op.get() : new TipoCarga();
	}

	@Override
	public List<TipoCarga> listar() {
		return tipoCargaRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		tipoCargaRepo.deleteById(id);
	}
	
}
