package com.empresalacteos.consulta_factura.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "movimiento_detalle")
public class MovimientoDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMovimientoDetalle;
		
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "razon_social")
	private String razonSocial;
	
	@Column(name = "fecha_pago")
	private LocalDate fechaPago;
	
	@Column(name = "numero_comprobante")
	private String numeroComprobante;
	
	@ManyToOne
	@JoinColumn(name = "id_movimiento", nullable = true, foreignKey = @ForeignKey(name = "fk_detallmov_movimiento"))
	private Movimiento movimiento;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_comprobante", nullable = true, foreignKey = @ForeignKey(name = "fk_movdell_tipocomprob"))
	private TipoComprobante tipoComprobante;
	
}
