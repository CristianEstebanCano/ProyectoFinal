package com.example.Parcial.Controller;

import com.example.Parcial.Model.Producto;
import com.example.Parcial.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //Obtener todos los productos
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    //Buscar
    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable int id) {
        return productoService.obtenerPorId(id);
    }

    //Guardar
    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    //Actualizar
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable int id, @RequestBody Producto productoActualizado) {
        Producto productoExistente = productoService.obtenerPorId(id);
        if (productoExistente != null) {
            productoExistente.setProducto_nombre(productoActualizado.getProducto_nombre());
            productoExistente.setProducto_precio_compra(productoActualizado.getProducto_precio_compra());
            productoExistente.setProducto_precio_venta(productoActualizado.getProducto_precio_venta());
            productoExistente.setProducto_stock_total(productoActualizado.getProducto_stock_total());
            productoExistente.setCategoria(productoActualizado.getCategoria());
            return productoService.guardar(productoExistente);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        productoService.eliminar(id);
    }

    // 2. Todos los productos con su categoria
    @GetMapping("/concategoria")
    public List<Object[]> obtenerProductosConCategoria() {
        return productoService.obtenerProductosConCategoria();
    }
}
