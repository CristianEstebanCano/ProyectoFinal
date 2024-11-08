package com.example.Parcial.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ventaDetalleId;

    private Integer ventaDetalleCantidad;

    private BigDecimal ventaDetalleTotal;

    @Column(length = 200)
    private String ventaDetalleDescripcion;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    public VentaDetalle() {}

    public VentaDetalle(Integer ventaDetalleId, Integer ventaDetalleCantidad, BigDecimal ventaDetalleTotal,
                        String ventaDetalleDescripcion, Venta venta, Producto producto) {
        this.ventaDetalleId = ventaDetalleId;
        this.ventaDetalleCantidad = ventaDetalleCantidad;
        this.ventaDetalleTotal = ventaDetalleTotal;
        this.ventaDetalleDescripcion = ventaDetalleDescripcion;
        this.venta = venta;
        this.producto = producto;
    }

    public Integer getVentaDetalleId() {
        return ventaDetalleId;
    }

    public void setVentaDetalleId(Integer ventaDetalleId) {
        this.ventaDetalleId = ventaDetalleId;
    }

    public Integer getVentaDetalleCantidad() {
        return ventaDetalleCantidad;
    }

    public void setVentaDetalleCantidad(Integer ventaDetalleCantidad) {
        this.ventaDetalleCantidad = ventaDetalleCantidad;
    }

    public BigDecimal getVentaDetalleTotal() {
        return ventaDetalleTotal;
    }

    public void setVentaDetalleTotal(BigDecimal ventaDetalleTotal) {
        this.ventaDetalleTotal = ventaDetalleTotal;
    }

    public String getVentaDetalleDescripcion() {
        return ventaDetalleDescripcion;
    }

    public void setVentaDetalleDescripcion(String ventaDetalleDescripcion) {
        this.ventaDetalleDescripcion = ventaDetalleDescripcion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "VentaDetalle{" +
                "ventaDetalleId=" + ventaDetalleId +
                ", ventaDetalleCantidad=" + ventaDetalleCantidad +
                ", ventaDetalleTotal=" + ventaDetalleTotal +
                ", ventaDetalleDescripcion='" + ventaDetalleDescripcion + '\'' +
                '}';
    }
}
