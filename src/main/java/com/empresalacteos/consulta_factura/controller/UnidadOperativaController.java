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

import com.empresalacteos.consulta_factura.model.UnidadOperativa;
import com.empresalacteos.consulta_factura.service.IUnidadOperativaService;



@RestController
@RequestMapping("/unidades-operativas")
public class UnidadOperativaController {
	@Autowired
	private IUnidadOperativaService unidadOperativaService;

	@GetMapping
	public List<UnidadOperativa> listar() {
		return unidadOperativaService.listar();
	}

	@GetMapping("/{id}")
	public UnidadOperativa listarPorId(@PathVariable("id") Integer id) {
		return unidadOperativaService.listarPorId(id);
	}

	@PostMapping
	public UnidadOperativa registrar(@RequestBody UnidadOperativa model) {
		return unidadOperativaService.registrar(model);
	}

	@PutMapping
	public UnidadOperativa modificar(@RequestBody UnidadOperativa model) {
		return unidadOperativaService.modificar(model);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		unidadOperativaService.eliminar(id);
	}
	
}
