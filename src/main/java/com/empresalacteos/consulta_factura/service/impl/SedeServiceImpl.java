package com.empresalacteos.consulta_factura.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresalacteos.consulta_factura.model.Sede;
import com.empresalacteos.consulta_factura.repo.ISedeRepo;
import com.empresalacteos.consulta_factura.service.ISedeService;



@Service
public class SedeServiceImpl implements ISedeService{
	@Autowired
	private ISedeRepo sedeRepo ;

	@Override
	public Sede registrar(Sede model) {
		return sedeRepo.save(model);
	}

	@Override
	public Sede modificar(Sede model) {
		return sedeRepo.save(model);
	}

	@Override
	public Sede listarPorId(Integer id) {
		Optional<Sede> op = sedeRepo.findById(id);
		return op.isPresent() ? op.get() : new Sede();
	}

	@Override
	public List<Sede> listar() {
		return sedeRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		sedeRepo.deleteById(id);
	}
}
