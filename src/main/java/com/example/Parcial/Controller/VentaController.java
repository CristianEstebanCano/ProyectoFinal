package com.example.Parcial.Controller;

import com.example.Parcial.Model.Producto;
import com.example.Parcial.Model.Venta;
import com.example.Parcial.Service.CajaService;
import com.example.Parcial.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> obtenerTodas() {
        return ventaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Venta obtenerPorId(@PathVariable String id) {
        return ventaService.obtenerPorId(id);
    }

    @PostMapping
    public Venta crear(@RequestBody Venta venta) {
        return ventaService.guardar(venta);
    }

    @PutMapping("/{id}")
    public Venta actualizar(@PathVariable String id, @RequestBody Venta venta) {
        venta.setVentaId(id);
        return ventaService.guardar(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        ventaService.eliminar(id);
    }
}
