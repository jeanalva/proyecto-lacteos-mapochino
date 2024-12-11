package com.empresalacteos.consulta_factura.singleton;

public class ConfiguradorSingleton {
	private String numeroRuc;
	private String nombreRazonSocial;
	private String direccion;
	private String telefono;
	private String correo;
	private static ConfiguradorSingleton configuradorSingleton;

	public static ConfiguradorSingleton getConfigurador(String numeroRuc, String nombreRazonSocial, String direccion,
			String telefono, String correo) {
		if (configuradorSingleton == null) {
			configuradorSingleton = new ConfiguradorSingleton(numeroRuc, nombreRazonSocial, direccion, telefono,
					correo);
		} else {
			System.out.println("No se puede crear el objeto porque ya existe un objeto de la clase");
		}
		return configuradorSingleton;
	}

	private ConfiguradorSingleton(String numeroRuc, String nombreRazonSocial, String direccion, String telefono,
			String correo) {
		this.numeroRuc = numeroRuc;
		this.nombreRazonSocial = nombreRazonSocial;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public String getNumeroRuc() {
		return numeroRuc;
	}

	public void setNumeroRuc(String numeroRuc) {
		this.numeroRuc = numeroRuc;
	}

	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}

	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
