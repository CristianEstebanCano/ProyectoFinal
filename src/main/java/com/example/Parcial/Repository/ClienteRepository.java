package com.example.Parcial.Repository;

import com.example.Parcial.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // 1.1 Obtener conteo de las compras de cada cliente y ordenarlo

    @Query(value = "SELECT cl.cliente_id, cl.cliente_nombre, COUNT(c.compra_id) AS total_compras " +
            "FROM cliente cl " +
            "INNER JOIN compra c ON cl.cliente_id = c.cliente_id " +
            "GROUP BY cl.cliente_id, cl.cliente_nombre " +
            "ORDER BY total_compras DESC", nativeQuery = true)
    List<Object[]> obtenerConteoComprasPorCliente();

}