package com.empresalacteos.consulta_factura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "apellido_paterno")
	private String apellidoPaterno;
	@Column(name = "apellido_materno")
	private String apellidoMaterno;
	@Column(name = "clave")
	private String clave;
	@Column(name = "celular")
	private String celular;
	@Column(name = "correo")
	private String correo;
	@Column(name = "eliminado")
	private int eliminado;
	@ManyToOne
	@JoinColumn(name = "id_perfil", nullable = true, foreignKey = @ForeignKey(name = "fk_usuario_perfil"))
	private Perfil perfil;
	@ManyToOne
	@JoinColumn(name = "id_sede", nullable = true, foreignKey = @ForeignKey(name = "fk_unidad_sede"))
	private Sede sede;
	@ManyToOne
	@JoinColumn(name = "id_unidad_operativa", nullable = true, foreignKey = @ForeignKey(name = "fk_usuario_unidad"))
	private UnidadOperativa unidadOperativa;

	//1. adapter
	private boolean activo; // declara un atributo private de tipo boolean

	public boolean estaActivo() {
		return activo;
	}

	public void activar() {
		activo = true;
	}

	public void desactivar() {
		activo = false;
	}
}
