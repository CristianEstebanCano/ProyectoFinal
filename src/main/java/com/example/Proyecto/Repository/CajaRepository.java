package com.example.Proyecto.Repository;

import com.example.Proyecto.Model.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CajaRepository extends JpaRepository<Caja, Integer> {

    // 5. Consulta para obtener el total de efectivo en cada caja sumando los totales de las compras, ordenado de mayor a menor
    @Query(value = "SELECT ca.caja_id, ca.caja_nombre, SUM(cp.compra_detalle_total) AS total_efectivo " +
            "FROM caja ca " +
            "INNER JOIN compra c ON ca.caja_id = c.caja_id " +
            "INNER JOIN compra_producto cp ON c.compra_id = cp.compra_id " +
            "GROUP BY ca.caja_id, ca.caja_nombre " +
            "ORDER BY total_efectivo DESC", nativeQuery = true)
    List<Object[]> obtenerTotalEfectivoPorCaja();

    // 5.1 Consulta para obtener el conteo de compras en cada caja, ordenado de mayor a menor
    @Query(value = "SELECT ca.caja_id, ca.caja_nombre, COUNT(c.compra_id) AS total_compras " +
            "FROM caja ca " +
            "INNER JOIN compra c ON ca.caja_id = c.caja_id " +
            "GROUP BY ca.caja_id, ca.caja_nombre " +
            "ORDER BY total_compras DESC", nativeQuery = true)
    List<Object[]> obtenerConteoComprasPorCaja();

}