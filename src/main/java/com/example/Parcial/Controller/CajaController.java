package com.example.Parcial.Controller;

import com.example.Parcial.Model.Caja;
import com.example.Parcial.Service.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cajas")
public class CajaController {

    @Autowired
    private CajaService cajaService;

    //Obtener lista de cajas
    @GetMapping
    public List<Caja> obtenerTodos() {
        return cajaService.obtenerTodos();
    }

    //Buscar
    @GetMapping("/{id}")
    public Caja obtenerPorId(@PathVariable int id) {
        return cajaService.obtenerPorId(id);
    }

    //Guardar
    @PostMapping
    public Caja guardar(@RequestBody Caja caja) {
        return cajaService.guardar(caja);
    }

    //Actualizar
    @PutMapping("/{id}")
    public Caja actualizar(@PathVariable int id, @RequestBody Caja caja) {
        Caja cajaExistente = cajaService.obtenerPorId(id);
        if (cajaExistente != null) {
            cajaExistente.setCaja_nombre(caja.getCaja_nombre());
            return cajaService.guardar(cajaExistente);
        } else {
            throw new RuntimeException("Caja no encontrada con id: " + id);
        }
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        cajaService.eliminar(id);
    }

    // 5. Obtener el efectivo total de cada caja, ordenado de mayor a menor
    @GetMapping("/efectivo")
    public List<Object[]> obtenerTotalEfectivoPorCaja() {
        return cajaService.obtenerTotalEfectivoPorCaja();
    }

    // 5.1 Obtener el conteo de compras por caja, ordenado de mayor a menor
    @GetMapping("/comprasconteo")
    public List<Object[]> obtenerConteoComprasPorCaja() {
        return cajaService.obtenerConteoComprasPorCaja();
    }

}
