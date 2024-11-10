package com.example.Proyecto.Service;

import com.example.Proyecto.Model.Producto;
import com.example.Proyecto.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    //Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    //Buscar
    public Producto obtenerPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    //Guardar
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    //Actualizar
    public Producto actualizar(Producto producto) {
        return productoRepository.save(producto);
    }

    //Eliminar
    public void eliminar(int id) {
        productoRepository.deleteById(id);
    }

    // 2. Obtener todos los productos con sus categorías
    public List<Object[]> obtenerProductosConCategoria() {
        return productoRepository.findProductosConCategoria();
    }
}
