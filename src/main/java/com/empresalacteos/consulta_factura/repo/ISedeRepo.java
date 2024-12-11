package com.empresalacteos.consulta_factura.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresalacteos.consulta_factura.model.Sede;


public interface ISedeRepo extends JpaRepository<Sede, Integer>{

}
