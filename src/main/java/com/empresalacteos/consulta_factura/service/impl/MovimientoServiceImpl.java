package com.empresalacteos.consulta_factura.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresalacteos.consulta_factura.model.Movimiento;
import com.empresalacteos.consulta_factura.repo.IMovimientoRepo;
import com.empresalacteos.consulta_factura.service.IMovimientoService;



@Service

// 4. Solid (I)
public class MovimientoServiceImpl implements IMovimientoService{
	@Autowired
	private IMovimientoRepo movimientoRepo ;

	@Override
	public Movimiento registrar(Movimiento model) {
		return movimientoRepo.save(model);
	}

	@Override
	public Movimiento modificar(Movimiento model) {
		return movimientoRepo.save(model);
	}

	@Override
	public Movimiento listarPorId(Integer id) {
		Optional<Movimiento> op = movimientoRepo.findById(id);
		return op.isPresent() ? op.get() : new Movimiento();
	}

	@Override
	public List<Movimiento> listar() {
		return movimientoRepo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		movimientoRepo.deleteById(id);
	}
	
	@Override
	public List<Movimiento> listarMovimientoPorUsuario(Integer id) {
		return movimientoRepo.listarMovimientoPorUsuario(id);
	}
	
	//5. Solid (D) parted 2
	public void calculoTotalDeComprobantes() {
		int sumatoria=0;
		sumatoria=10;
		System.out.println("Impresion del caculo total"+sumatoria);
	}
	
}
