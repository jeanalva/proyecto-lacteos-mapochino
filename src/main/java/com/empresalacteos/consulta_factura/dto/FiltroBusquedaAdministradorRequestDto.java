package com.empresalacteos.consulta_factura.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FiltroBusquedaAdministradorRequestDto {
	private Integer idMovimiento;
	private String ruc;
	private String numeroComprobante;
	private LocalDate fechaPago;
}
