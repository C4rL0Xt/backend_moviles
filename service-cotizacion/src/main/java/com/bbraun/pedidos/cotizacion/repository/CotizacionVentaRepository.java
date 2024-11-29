package com.bbraun.pedidos.cotizacion.repository;

import com.bbraun.pedidos.cotizacion.models.entity.CotizacionVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CotizacionVentaRepository extends JpaRepository<CotizacionVenta,String> {

    @Query(value = "SELECT c.id_cotizacion FROM CotizacionVenta c ORDER BY c.id_cotizacion DESC")
    List<String> findLastCode();

    @Query("SELECT c FROM CotizacionVenta c WHERE c.id_cotizacion = ?1")
    CotizacionVenta findByIdCotizacion(String idCotizacion);


    @Query(value = "SELECT c.empresa, SUM(cv.monto_total) FROM cliente c "+
            "JOIN pedidos p "+
            "ON p.idcliente = c.id_cliente "+
            " JOIN cotizaciones_venta cv "+
            "ON cv.id_cotizacion = p.idcotizacion "+
            "GROUP BY c.empresa " +
            "ORDER BY SUM(cv.monto_total) DESC "+
            "LIMIT 3;", nativeQuery = true)
    List<Object[]> getTopCustomers();


    @Query(value = "SELECT TO_CHAR(p.fechaemision, 'TMMonth') AS nombre_mes, SUM(cv.monto_total) AS monto_total_mensual "+
            "FROM pedidos p "+
            "JOIN cotizaciones_venta cv "+
            "   ON p.idcotizacion = cv.id_cotizacion "+
            "GROUP BY TO_CHAR(p.fechaemision, 'TMMonth') "+
            "ORDER BY MIN(p.fechaemision);",nativeQuery = true)
    List<Object[]> getSalesData();



}
