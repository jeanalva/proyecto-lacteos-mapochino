package com.empresalacteos.consulta_factura.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresalacteos.consulta_factura.model.Usuario;
import com.empresalacteos.consulta_factura.repo.IUsuarioRepo;
import com.empresalacteos.consulta_factura.service.IUsuarioService;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public List<Usuario> listar() {
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario registrar(Usuario model) {
		return usuarioRepo.save(model);
	}

	@Override
	public Usuario modificar(Usuario model) {
		Optional<Usuario> op = usuarioRepo.findById(model.getIdUsuario());
		if(op.isPresent()) {
			model.setClave(op.get().getClave());
		}
		return usuarioRepo.save(model);
	}

	@Override
	public Usuario listarPorId(Integer id) {
		Optional<Usuario> op = usuarioRepo.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}


	@Override
	public void eliminar(Integer id) {
		usuarioRepo.deleteById(id);
	}

	@Override
	public Usuario findByUsuario(String usuario) {
		return usuarioRepo.findByUsuario(usuario);
	}

}
