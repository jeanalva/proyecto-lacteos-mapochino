package com.empresalacteos.consulta_factura.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresalacteos.consulta_factura.model.Movimiento;

public interface IMovimientoRepo extends JpaRepository<Movimiento, Integer> {
	
	@Query(value = "select * from movimiento where id_usuario =:id ", nativeQuery = true)
	List<Movimiento> listarMovimientoPorUsuario(@Param("id") Integer id);

}
