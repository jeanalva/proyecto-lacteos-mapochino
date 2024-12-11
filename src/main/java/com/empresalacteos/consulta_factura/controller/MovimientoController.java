package com.empresalacteos.consulta_factura.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
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

import com.empresalacteos.consulta_factura.model.Movimiento;
import com.empresalacteos.consulta_factura.service.IMovimientoService;
import com.empresalacteos.consulta_factura.service.IUsuarioService;


@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
	@Autowired
	private IMovimientoService movimientoService;
	
	//2. principio solid  (O)
	@Autowired
	private IUsuarioService usuarioService;
	
//	@GetMapping
//	public List<Usuario> listarUsuario() {
//		return usuarioService.listar();
//	}
	//final 

	@GetMapping
	public List<Movimiento> listar() {
		return movimientoService.listar();
	}

	@GetMapping("/{id}")
	public Movimiento listarPorId(@PathVariable("id") Integer id) {
		return movimientoService.listarPorId(id);
	}

	@PostMapping
	public Movimiento registrar(@RequestBody Movimiento model) {
		model.setFechaHoraCarga(LocalDateTime.now(ZoneId.of("America/Lima")));
		return movimientoService.registrar(model);
	}

	@PutMapping
	public Movimiento modificar(@RequestBody Movimiento model) {
		return movimientoService.modificar(model);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		movimientoService.eliminar(id);
	}
	
	@GetMapping("/usuario/{id}")
	public List<Movimiento> listarMovimientoPorUsuario(@PathVariable("id") Integer id) {
		return movimientoService.listarMovimientoPorUsuario(id);
	}

}
