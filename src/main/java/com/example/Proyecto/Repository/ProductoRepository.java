package com.example.Proyecto.Repository;

import com.example.Proyecto.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // 2. Todos los productos son su categoria
    @Query(value = "SELECT p.producto_id, p.producto_nombre, c.categoria_nombre " +
            "FROM producto p " +
            "INNER JOIN categoria c ON p.categoria_id = c.categoria_id", nativeQuery = true)
    List<Object[]> findProductosConCategoria();

}