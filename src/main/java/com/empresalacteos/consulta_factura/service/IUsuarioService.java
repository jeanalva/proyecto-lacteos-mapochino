package com.empresalacteos.consulta_factura.service;

import com.empresalacteos.consulta_factura.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario> {

	Usuario findByUsuario(String usuario);
}
