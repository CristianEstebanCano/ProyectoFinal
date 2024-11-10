package com.example.Parcial.Controller;

import com.example.Parcial.Model.CompraProducto;
import com.example.Parcial.Service.CompraProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/compraproductos")
public class CompraProductoController {

    @Autowired
    private CompraProductoService compraProductoService;

    // Obtener todos los CompraProducto
    @GetMapping
    public List<CompraProducto> obtenerTodos() {
        return compraProductoService.obtenerTodos();
    }

    // Buscar
    @GetMapping("/{id}")
    public CompraProducto obtenerPorId(@PathVariable int id) {
        return compraProductoService.obtenerPorId(id);
    }

    // Guardar
    @PostMapping
    public CompraProducto guardar(@RequestBody CompraProducto compraProducto) {
        return compraProductoService.guardar(compraProducto);
    }

    // Actualizar
    @PutMapping("/{id}")
    public CompraProducto actualizar(@PathVariable int id, @RequestBody CompraProducto compraProducto) {
        return compraProductoService.actualizar(id, compraProducto);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        compraProductoService.eliminar(id);
    }
}
