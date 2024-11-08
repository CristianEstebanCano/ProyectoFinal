package com.example.Parcial.Controller;

import com.example.Parcial.Model.Caja;
import com.example.Parcial.Service.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cajas")
public class CajaController {

    @Autowired
    private CajaService cajaService;

    @GetMapping
    public List<Caja> obtenerTodas() {
        return cajaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Caja obtenerPorId(@PathVariable Integer id) {
        return cajaService.obtenerPorId(id);
    }

    @PostMapping
    public Caja crear(@RequestBody Caja caja) {
        return cajaService.guardar(caja);
    }

    @PutMapping("/{id}")
    public Caja actualizar(@PathVariable Integer id, @RequestBody Caja caja) {
        caja.setCajaId(id);
        return cajaService.guardar(caja);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        cajaService.eliminar(id);
    }
}
