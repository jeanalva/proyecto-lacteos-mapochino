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

import com.empresalacteos.consulta_factura.model.TipoComprobante;
import com.empresalacteos.consulta_factura.service.ITipoComprobanteService;



@RestController
@RequestMapping("/tipos-comprobantes")
public class TipoComprobanteController {

	@Autowired
	private ITipoComprobanteService tipoComprobanteService;

	@GetMapping
	public List<TipoComprobante> listar() {
		return tipoComprobanteService.listar();
	}

	@GetMapping("/{id}")
	public TipoComprobante listarPorId(@PathVariable("id") Integer id) {
		return tipoComprobanteService.listarPorId(id);
	}

	@PostMapping
	public TipoComprobante registrar(@RequestBody TipoComprobante model) {
		return tipoComprobanteService.registrar(model);
	}

	@PutMapping
	public TipoComprobante modificar(@RequestBody TipoComprobante model) {
		return tipoComprobanteService.modificar(model);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		tipoComprobanteService.eliminar(id);
	}
}
