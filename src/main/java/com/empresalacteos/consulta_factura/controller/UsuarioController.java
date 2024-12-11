package com.empresalacteos.consulta_factura.controller;

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

import com.empresalacteos.consulta_factura.model.Usuario;
import com.empresalacteos.consulta_factura.service.IUsuarioService;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping
	public List<Usuario> listar() {
		return usuarioService.listar();
	}

	@GetMapping("/{id}")
	public Usuario listarPorId(@PathVariable("id") Integer id) {
		return usuarioService.listarPorId(id);
	}

	@PostMapping
	public Usuario registrar(@RequestBody Usuario model) {
		return usuarioService.registrar(model);
	}

	@PutMapping
	public Usuario modificar(@RequestBody Usuario model) {
		return usuarioService.modificar(model);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		usuarioService.eliminar(id);
	}

	@GetMapping("/user/{usuario}")
	public Usuario findByUsuario(@PathVariable("usuario") String usuario) {
		return usuarioService.findByUsuario(usuario);
	}

}
