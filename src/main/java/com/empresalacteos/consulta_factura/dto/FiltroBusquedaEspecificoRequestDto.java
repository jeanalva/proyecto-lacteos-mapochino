package com.empresalacteos.consulta_factura.dto;

import lombok.Data;

@Data
public class FiltroBusquedaEspecificoRequestDto {
	private Integer idMovimiento;
	private String numeroComprobante;
}