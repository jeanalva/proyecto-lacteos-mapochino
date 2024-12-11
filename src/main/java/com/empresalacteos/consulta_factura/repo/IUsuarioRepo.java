package com.empresalacteos.consulta_factura.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresalacteos.consulta_factura.model.Usuario;


public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	Usuario findByUsuario(String usuario);
	

}
