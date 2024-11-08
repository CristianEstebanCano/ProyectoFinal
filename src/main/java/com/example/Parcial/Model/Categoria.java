package com.example.Parcial.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaId;

    @Column(length = 50, nullable = false)
    private String categoriaNombre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Categoria() {}

    public Categoria(Integer categoriaId, String categoriaNombre) {
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "categoriaId=" + categoriaId +
                ", categoriaNombre='" + categoriaNombre + '\'' +
                '}';
    }
}
