package com.empresalacteos.consulta_factura.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresalacteos.consulta_factura.model.UnidadOperativa;
import com.empresalacteos.consulta_factura.repo.IUnidadOperativaRepo;
import com.empresalacteos.consulta_factura.service.IUnidadOperativaService;



@Service
public class UnidadOperativaServiceImpl  implements IUnidadOperativaService{

	@Autowired
	private IUnidadOperativaRepo unidadOperativaRepo ;

	@Override
	public UnidadOperativa registrar(UnidadOperativa model) {
		return unidadOperativaRepo.save(model);
	}

	@Override
	public UnidadOperativa modificar(UnidadOperativa model) {
		return unidadOperativaRepo.save(model);
	}

	@Override
	public UnidadOperativa listarPorId(Integer id) {
		Optional<UnidadOperativa> op = unidadOperativaRepo.findById(id);
		return op.isPresent() ? op.get() : new UnidadOperativa();
	}

	@Override
	public List<UnidadOperativa> listar() {
		return unidadOperativaRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		unidadOperativaRepo.deleteById(id);
	}
}
