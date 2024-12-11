package com.empresalacteos.consulta_factura.dto;

import com.empresalacteos.consulta_factura.model.Movimiento;
import com.empresalacteos.consulta_factura.model.MovimientoDetalle;
import com.empresalacteos.consulta_factura.model.Sede;
import com.empresalacteos.consulta_factura.model.Usuario;

import lombok.Data;


@Data
public class registrarComprobanteDto {
	private Movimiento movimiento;
	private Sede sede;
	private Usuario usuario;
	private MovimientoDetalle movimientoDetalle;
}
