package com.empresalacteos.consulta_factura.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresalacteos.consulta_factura.model.UnidadOperativa;


public interface IUnidadOperativaRepo extends JpaRepository<UnidadOperativa, Integer> {

}
