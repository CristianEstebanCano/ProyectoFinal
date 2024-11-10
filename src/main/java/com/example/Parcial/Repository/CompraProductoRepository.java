package com.example.Parcial.Repository;

import com.example.Parcial.Model.CompraProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraProductoRepository extends JpaRepository<CompraProducto, Integer> {
}