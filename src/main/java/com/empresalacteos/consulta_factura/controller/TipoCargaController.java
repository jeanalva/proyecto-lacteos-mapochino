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

import com.empresalacteos.consulta_factura.model.TipoCarga;
import com.empresalacteos.consulta_factura.service.ITipoCargaService;



@RestController
@RequestMapping("/tipos-cargas")
public class TipoCargaController {

	@Autowired
	private ITipoCargaService tipoCargaService;

	@GetMapping
	public List<TipoCarga> listar() {
		return tipoCargaService.listar();
	}

	@GetMapping("/{id}")
	public TipoCarga listarPorId(@PathVariable("id") Integer id) {
		return tipoCargaService.listarPorId(id);
	}

	@PostMapping
	public TipoCarga registrar(@RequestBody TipoCarga model) {
		return tipoCargaService.registrar(model);
	}

	@PutMapping
	public TipoCarga modificar(@RequestBody TipoCarga model) {
		return tipoCargaService.modificar(model);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		tipoCargaService.eliminar(id);
	}
}
