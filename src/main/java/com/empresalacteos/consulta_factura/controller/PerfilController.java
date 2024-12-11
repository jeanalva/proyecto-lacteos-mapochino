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

import com.empresalacteos.consulta_factura.model.Perfil;
import com.empresalacteos.consulta_factura.service.IPerfilService;


@RestController
@RequestMapping("/perfiles")
public class PerfilController {
	@Autowired
	private IPerfilService perfilService;

	@GetMapping
	public List<Perfil> listar() {
		return perfilService.listar();
	}

	@GetMapping("/{id}")
	public Perfil listarPorId(@PathVariable("id") Integer id) {
		return perfilService.listarPorId(id);
	}

	@PostMapping
	public Perfil registrar(@RequestBody Perfil model) {
		return perfilService.registrar(model);
	}

	@PutMapping
	public Perfil modificar(@RequestBody Perfil model) {
		return perfilService.modificar(model);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		perfilService.eliminar(id);
	}
	
}
