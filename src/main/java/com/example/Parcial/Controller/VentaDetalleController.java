package com.example.Parcial.Controller;

import com.example.Parcial.Model.Venta;
import com.example.Parcial.Model.VentaDetalle;
import com.example.Parcial.Service.VentaDetalleService;
import com.example.Parcial.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta-detalles")
public class VentaDetalleController {

    @Autowired
    private VentaDetalleService ventaDetalleService;

    @GetMapping
    public List<VentaDetalle> obtenerTodos() {
        return ventaDetalleService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public VentaDetalle obtenerPorId(@PathVariable Integer id) {
        return ventaDetalleService.obtenerPorId(id);
    }

    @PostMapping
    public VentaDetalle crear(@RequestBody VentaDetalle ventaDetalle) {
        return ventaDetalleService.guardar(ventaDetalle);
    }

    @PutMapping("/{id}")
    public VentaDetalle actualizar(@PathVariable Integer id, @RequestBody VentaDetalle ventaDetalle) {
        ventaDetalle.setVentaDetalleId(id);
        return ventaDetalleService.guardar(ventaDetalle);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        ventaDetalleService.eliminar(id);
    }
}
