package com.example.Proyecto.Controller;

import com.example.Proyecto.Model.Cliente;
import com.example.Proyecto.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //Obtener lista de clientes
    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteService.obtenerTodos();
    }

    //Buscar
    @GetMapping("/{id}")
    public Cliente obtenerPorId(@PathVariable int id) {
        return clienteService.obtenerPorId(id);
    }

    //Guardar
    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    //Actualizar
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable int id, @RequestBody Cliente clienteActualizado) {
        return clienteService.actualizar(id, clienteActualizado);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        clienteService.eliminar(id);
    }

    // 1.1 Conteo compras por cliente ordenado
    @GetMapping("/comprasconteo")
    public List<Object[]> obtenerConteoComprasPorCliente() {
        return clienteService.obtenerConteoComprasPorCliente();
    }
}
