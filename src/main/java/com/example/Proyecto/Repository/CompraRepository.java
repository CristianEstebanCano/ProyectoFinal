package com.example.Proyecto.Repository;

import com.example.Proyecto.Model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

    // 1. Consulta para obtener las compras de un cliente específico junto con los nombres del cliente y la caja
    @Query(value = "SELECT c.compra_id, c.compra_fecha, cl.cliente_nombre, ca.caja_nombre " +
            "FROM compra c " +
            "INNER JOIN cliente cl ON c.cliente_id = cl.cliente_id " +
            "INNER JOIN caja ca ON c.caja_id = ca.caja_id " +
            "WHERE c.cliente_id = :clienteId", nativeQuery = true)
    List<Object[]> findComprasByCliente(@Param("clienteId") int clienteId);

    // 3. Consulta para obtener las compras de un cliente específico junto con detalles de cada compra
    @Query(value = "SELECT c.compra_id, c.compra_fecha, cl.cliente_nombre, " +
            "cp.compraproducto_id, cp.compra_detalle_cantidad, cp.compra_detalle_total, p.producto_nombre " +
            "FROM compra c " +
            "INNER JOIN cliente cl ON c.cliente_id = cl.cliente_id " +
            "INNER JOIN compraproducto cp ON c.compra_id = cp.compra_id " +
            "INNER JOIN producto p ON cp.producto_id = p.producto_id " +
            "WHERE c.cliente_id = :clienteId " +
            "ORDER BY c.compra_fecha DESC", nativeQuery = true)
    List<Object[]> findComprasConDetallesByCliente(@Param("clienteId") int clienteId);

    // 4. Consulta para obtener todas las compras junto con todos los detalles relacionados, incluyendo la categoría del producto
    @Query(value = "SELECT c.compra_id, c.compra_fecha, cl.cliente_nombre, " +
            "ca.caja_nombre, cp.compraproducto_id, cp.compra_detalle_cantidad, cp.compra_detalle_total, " +
            "p.producto_nombre, p.producto_precio_venta, cat.categoria_nombre " +
            "FROM compra c " +
            "INNER JOIN cliente cl ON c.cliente_id = cl.cliente_id " +
            "INNER JOIN caja ca ON c.caja_id = ca.caja_id " +
            "INNER JOIN compraproducto cp ON c.compra_id = cp.compra_id " +
            "INNER JOIN producto p ON cp.producto_id = p.producto_id " +
            "INNER JOIN categoria cat ON p.categoria_id = cat.categoria_id " +
            "ORDER BY c.compra_fecha DESC", nativeQuery = true)
    List<Object[]> findAllComprasConDetalles();

}