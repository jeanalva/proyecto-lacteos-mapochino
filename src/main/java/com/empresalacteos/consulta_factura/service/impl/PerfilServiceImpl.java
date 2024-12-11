package com.empresalacteos.consulta_factura.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresalacteos.consulta_factura.model.Perfil;
import com.empresalacteos.consulta_factura.repo.IPerfilRepo;
import com.empresalacteos.consulta_factura.service.IPerfilService;



@Service
public class PerfilServiceImpl implements IPerfilService {
	
	@Autowired
	private IPerfilRepo perfilRepo ;

	@Override
	public Perfil registrar(Perfil model) {
		return perfilRepo.save(model);
	}

	@Override
	public Perfil modificar(Perfil model) {
		return perfilRepo.save(model);
	}

	@Override
	public Perfil listarPorId(Integer id) {
		Optional<Perfil> op = perfilRepo.findById(id);
		return op.isPresent() ? op.get() : new Perfil();
	}

	@Override
	public List<Perfil> listar() {
		return perfilRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		perfilRepo.deleteById(id);
	}

}
