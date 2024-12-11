package com.empresalacteos.consulta_factura.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresalacteos.consulta_factura.model.MovimientoDetalle;

public interface IMovimientoDetalleRepo extends JpaRepository<MovimientoDetalle, Integer> {
	
	@Query(value = "select * from movimiento_detalle where id_movimiento =:id ", nativeQuery = true)
	List<MovimientoDetalle> listarDetallePorMovimiento(@Param("id") Integer id);
	
	@Query(value = "select * from movimiento_detalle where ruc =:ruc ", nativeQuery = true)
	List<MovimientoDetalle> listarDetallePorRuc(@Param("ruc") String ruc);
	
	//busqueda consultor
	@Query(value ="select * from movimiento_detalle m where (:idTipoComprobante is null or m.id_tipo_comprobante = :idTipoComprobante) AND (:numeroComprobante is null or m.numero_comprobante = :numeroComprobante)", nativeQuery = true)
	List<MovimientoDetalle> buscarPorTipoYnumero(@Param("idTipoComprobante") Integer idTipoComprobante, @Param("numeroComprobante") String numeroComprobante);
	
	@Query(value ="select * from movimiento_detalle m where (m.id_tipo_comprobante = :idTipoComprobante) AND (:numeroComprobante is null or m.numero_comprobante = :numeroComprobante) AND (m.fecha_pago =:fechaPago) ", nativeQuery = true)
	List<MovimientoDetalle> buscarPorfechaTipoYnumero(@Param("idTipoComprobante") Integer idTipoComprobante, @Param("numeroComprobante") String numeroComprobante, @Param("fechaPago") LocalDate fechaPago);
	
	//busqueda especifica
	@Query(value = "select * from movimiento_detalle where (id_movimiento=:idMovimiento) AND (numero_comprobante =:numeroComprobante) ", nativeQuery = true)
	List<MovimientoDetalle> buscarEspecifico(@Param("idMovimiento") Number idMovimiento, @Param("numeroComprobante") String numeroComprobante);
	
}
