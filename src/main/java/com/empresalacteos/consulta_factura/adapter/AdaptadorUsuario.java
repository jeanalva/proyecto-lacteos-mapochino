package com.empresalacteos.consulta_factura.adapter;

public class AdaptadorUsuario { // entidad que aplica el patron adapter
	
	private UsuarioSuspendido suspendido = new UsuarioSuspendido(); // crean una nuevo objeto vacio

	public boolean estaActivado() { //metodo que valida si el usuario suspendido esta activo o inhabilitado
		return suspendido.isOn();
	}

	public void activar() {
		suspendido.on();
	}

	public void desactivar() {
		suspendido.off();
	}
}
