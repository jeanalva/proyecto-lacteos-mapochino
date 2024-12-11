package com.empresalacteos.consulta_factura.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresalacteos.consulta_factura.model.TipoComprobante;


public interface ITipoComprobanteRepo extends JpaRepository<TipoComprobante, Integer>{

}
