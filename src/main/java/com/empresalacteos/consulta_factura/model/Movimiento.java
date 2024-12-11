package com.empresalacteos.consulta_factura.model;

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
@Table(name = "movimiento")
public class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMovimiento;
	
	@Column(name = "cantidad_total")
	private int cantidadTotal;
	
	@Column(name = "fecha_hora_carga")
	private LocalDateTime fechaHoraCarga;
	
	@ManyToOne
	@JoinColumn(name = "id_sede", nullable = true, foreignKey = @ForeignKey(name = "fk_mov_sede"))
	private Sede sede;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = true, foreignKey = @ForeignKey(name = "fk_mov_usuario"))
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_carga", nullable = true, foreignKey = @ForeignKey(name = "fk_mov_tipocarga"))
	private TipoCarga tipoCarga;
	
}
