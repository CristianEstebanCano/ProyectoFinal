package com.example.Proyecto.Controller;

import com.example.Proyecto.Model.Categoria;
import com.example.Proyecto.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //Obtener todas las categorias
    @GetMapping
    public List<Categoria> obtenerTodos() {
        return categoriaService.obtenerTodos();
    }

    //Buscar
    @GetMapping("/{id}")
    public Categoria obtenerPorId(@PathVariable int id) {
        return categoriaService.obtenerPorId(id);
    }

    //Guardar
    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }

    //Actualizar
    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable int id, @RequestBody Categoria categoria) {
        return categoriaService.actualizar(id, categoria);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        categoriaService.eliminar(id);
    }
}
