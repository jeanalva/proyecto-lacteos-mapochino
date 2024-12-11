package com.empresalacteos.consulta_factura.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresalacteos.consulta_factura.model.TipoCarga;


public interface ITipoCargaRepo extends JpaRepository<TipoCarga, Integer>{

}
