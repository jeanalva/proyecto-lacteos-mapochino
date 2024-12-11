package com.empresalacteos.consulta_factura.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FiltroConsultorRequestDto {
	private LocalDate fechaPago;
	private int idTipoComprobante;
	private String numeroComprobante;
}
