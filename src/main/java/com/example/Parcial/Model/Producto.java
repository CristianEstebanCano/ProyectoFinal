package com.example.Parcial.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;

    @Column(length = 100, nullable = false)
    private String productoNombre;

    private Integer productoStockTotal;

    @Column(length = 20)
    private String productoTipoUnidad;

    private BigDecimal productoPrecioCompra;

    private BigDecimal productoPrecioVenta;

    @Column(length = 35)
    private String productoModelo;

    @Column(length = 20)
    private String productoEstado;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<VentaDetalle> ventaDetalles;

    // Constructor vacío
    public Producto() {}

    // Constructor lleno
    public Producto(Integer productoId, String productoNombre, Integer productoStockTotal, String productoTipoUnidad,
                    BigDecimal productoPrecioCompra, BigDecimal productoPrecioVenta, String productoModelo,
                    String productoEstado, Categoria categoria) {
        this.productoId = productoId;
        this.productoNombre = productoNombre;
        this.productoStockTotal = productoStockTotal;
        this.productoTipoUnidad = productoTipoUnidad;
        this.productoPrecioCompra = productoPrecioCompra;
        this.productoPrecioVenta = productoPrecioVenta;
        this.productoModelo = productoModelo;
        this.productoEstado = productoEstado;
        this.categoria = categoria;
    }

    // Getters y Setters
    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public Integer getProductoStockTotal() {
        return productoStockTotal;
    }

    public void setProductoStockTotal(Integer productoStockTotal) {
        this.productoStockTotal = productoStockTotal;
    }

    public String getProductoTipoUnidad() {
        return productoTipoUnidad;
    }

    public void setProductoTipoUnidad(String productoTipoUnidad) {
        this.productoTipoUnidad = productoTipoUnidad;
    }

    public BigDecimal getProductoPrecioCompra() {
        return productoPrecioCompra;
    }

    public void setProductoPrecioCompra(BigDecimal productoPrecioCompra) {
        this.productoPrecioCompra = productoPrecioCompra;
    }

    public BigDecimal getProductoPrecioVenta() {
        return productoPrecioVenta;
    }

    public void setProductoPrecioVenta(BigDecimal productoPrecioVenta) {
        this.productoPrecioVenta = productoPrecioVenta;
    }

    public String getProductoModelo() {
        return productoModelo;
    }

    public void setProductoModelo(String productoModelo) {
        this.productoModelo = productoModelo;
    }

    public String getProductoEstado() {
        return productoEstado;
    }

    public void setProductoEstado(String productoEstado) {
        this.productoEstado = productoEstado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<VentaDetalle> getVentaDetalles() {
        return ventaDetalles;
    }

    public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
        this.ventaDetalles = ventaDetalles;
    }

    // Método toString
    @Override
    public String toString() {
        return "Producto{" +
                "productoId=" + productoId +
                ", productoNombre='" + productoNombre + '\'' +
                ", productoStockTotal=" + productoStockTotal +
                ", productoTipoUnidad='" + productoTipoUnidad + '\'' +
                ", productoPrecioCompra=" + productoPrecioCompra +
                ", productoPrecioVenta=" + productoPrecioVenta +
                ", productoModelo='" + productoModelo + '\'' +
                ", productoEstado='" + productoEstado + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
