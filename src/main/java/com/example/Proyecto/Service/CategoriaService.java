package com.example.Proyecto.Service;

import com.example.Proyecto.Model.Categoria;
import com.example.Proyecto.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener lista de categorias
    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    // Obtener
    public Categoria obtenerPorId(int id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        } else {
            throw new RuntimeException("Categoría no encontrada con ID: " + id);
        }
    }

    //Guardar
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    //Actualizar
    public Categoria actualizar(int id, Categoria categoriaActualizada) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setCategoria_nombre(categoriaActualizada.getCategoria_nombre());
            return categoriaRepository.save(categoria);
        } else {
            throw new RuntimeException("Categoría no encontrada con ID: " + id);
        }
    }

    //Eliminar
    public void eliminar(int id) {
        categoriaRepository.deleteById(id);
    }
}
