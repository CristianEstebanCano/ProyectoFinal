package com.example.Parcial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int producto_id;

    private String producto_nombre;
    private double producto_precio_compra;
    private double producto_precio_venta;
    private int producto_stock_total;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<CompraProducto> compras;

    public Producto() {
    }

    public Producto(int producto_id, String producto_nombre, double producto_precio_compra, double producto_precio_venta, int producto_stock_total, Categoria categoria) {
        this.producto_id = producto_id;
        this.producto_nombre = producto_nombre;
        this.producto_precio_compra = producto_precio_compra;
        this.producto_precio_venta = producto_precio_venta;
        this.producto_stock_total = producto_stock_total;
        this.categoria = categoria;
    }

    // Getters y Setters
    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public double getProducto_precio_compra() {
        return producto_precio_compra;
    }

    public void setProducto_precio_compra(double producto_precio_compra) {
        this.producto_precio_compra = producto_precio_compra;
    }

    public double getProducto_precio_venta() {
        return producto_precio_venta;
    }

    public void setProducto_precio_venta(double producto_precio_venta) {
        this.producto_precio_venta = producto_precio_venta;
    }

    public int getProducto_stock_total() {
        return producto_stock_total;
    }

    public void setProducto_stock_total(int producto_stock_total) {
        this.producto_stock_total = producto_stock_total;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<CompraProducto> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraProducto> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "producto_id=" + producto_id +
                ", producto_nombre='" + producto_nombre + '\'' +
                ", producto_precio_compra=" + producto_precio_compra +
                ", producto_precio_venta=" + producto_precio_venta +
                ", producto_stock_total=" + producto_stock_total +
                '}';
    }
}