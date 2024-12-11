package com.empresalacteos.consulta_factura.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresalacteos.consulta_factura.model.Perfil;


public interface IPerfilRepo extends JpaRepository<Perfil, Integer>{

}
