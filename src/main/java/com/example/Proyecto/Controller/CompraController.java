package com.example.Proyecto.Controller;

import com.example.Proyecto.Model.Compra;
import com.example.Proyecto.Repository.CompraProductoRepository;
import com.example.Proyecto.Service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private CompraProductoRepository compraProductoRepository;

    //Obtener lista de compras
    @GetMapping
    public List<Compra> obtenerTodos() {
        return compraService.obtenerTodos();
    }

    //Buscar
    @GetMapping("/{id}")
    public Compra obtenerPorId(@PathVariable int id) {
        return compraService.obtenerPorId(id);
    }

    //Guardar
    @PostMapping
    public Compra guardar(@RequestBody Compra compra) {
        Compra compraGuardada = compraService.guardar(compra);
        return compraGuardada;
    }

    //Actualizar
    @PutMapping("/{id}")
    public Compra actualizar(@PathVariable int id, @RequestBody Compra compra) {

        Compra compraExistente = compraService.obtenerPorId(id);
        if (compraExistente != null) {
            compraExistente.setCompra_fecha(compra.getCompra_fecha());
            compraExistente.setCliente(compra.getCliente());
            compraExistente.setCaja(compra.getCaja());
            Compra compraActualizada = compraService.actualizar(compraExistente);
            return compraActualizada;
        }
        return null;
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        compraService.eliminar(id);
    }

    // 1. Obtener compras de un cliente específico con las cajas asociadas
    @GetMapping("/cliente/{clienteId}")
    public List<Object[]> obtenerComprasPorCliente(@PathVariable int clienteId) {
        return compraService.obtenerComprasPorCliente(clienteId);
    }

    // 3. Obtener todas las compras de un cliente con sus detalles, organizadas por fecha
    @GetMapping("/cliente/{clienteId}/detalles")
    public List<Object[]> obtenerComprasConDetallesPorCliente(@PathVariable int clienteId) {
        return compraService.obtenerComprasConDetallesPorCliente(clienteId);
    }

    // 4. Obtener todas las compras con detalles, enlazando todas las tablas
    @GetMapping("/detalles/completos")
    public List<Object[]> obtenerTodasLasComprasConDetalles() {
        return compraService.obtenerTodasLasComprasConDetalles();
    }
}
