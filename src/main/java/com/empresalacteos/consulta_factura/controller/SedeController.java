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

import com.empresalacteos.consulta_factura.model.Sede;
import com.empresalacteos.consulta_factura.service.ISedeService;

@RestController
@RequestMapping("/sedes")
public class SedeController {

	@Autowired
	private ISedeService sedeService;

	@GetMapping
	public List<Sede> listar() {
		return sedeService.listar();
	}

	@GetMapping("/{id}")
	public Sede listarPorId(@PathVariable("id") Integer id) {
		return sedeService.listarPorId(id);
	}

	@PostMapping
	public Sede registrar(@RequestBody Sede model) {
		return sedeService.registrar(model);
	}

	@PutMapping
	public Sede modificar(@RequestBody Sede model) {
		return sedeService.modificar(model);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		sedeService.eliminar(id);
	}
}
