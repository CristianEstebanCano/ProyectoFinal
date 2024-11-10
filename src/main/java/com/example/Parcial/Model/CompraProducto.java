package com.example.Parcial.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class CompraProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compraproducto_id;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)  // Verifica que este campo no sea nulo
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)  // Verifica que este campo no sea nulo
    private Producto producto;

    private int compra_detalle_cantidad;

    private BigDecimal compra_detalle_total;

    public CompraProducto() {}

    public CompraProducto(Compra compra, Producto producto, int compra_detalle_cantidad) {
        this.compra = compra;
        this.producto = producto;
        this.compra_detalle_cantidad = compra_detalle_cantidad;
        this.compra_detalle_total = BigDecimal.ZERO;  // Inicialización en 0
    }

    public int getCompraproducto_id() {
        return compraproducto_id;
    }

    public void setCompraproducto_id(int compraproducto_id) {
        this.compraproducto_id = compraproducto_id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCompra_detalle_cantidad() {
        return compra_detalle_cantidad;
    }

    public void setCompra_detalle_cantidad(int compra_detalle_cantidad) {
        this.compra_detalle_cantidad = compra_detalle_cantidad;
    }

    public BigDecimal getCompra_detalle_total() {
        return compra_detalle_total;
    }

    public void setCompra_detalle_total(BigDecimal compra_detalle_total) {
        this.compra_detalle_total = compra_detalle_total;
    }

    public BigDecimal calcularTotal() {
        if (producto != null && producto.getProducto_precio_venta() > 0) {

            BigDecimal precioVenta = BigDecimal.valueOf(producto.getProducto_precio_venta());

            System.out.println("Precio de Venta: " + precioVenta);
            System.out.println("Cantidad: " + compra_detalle_cantidad);

            BigDecimal cantidad = new BigDecimal(compra_detalle_cantidad);
            BigDecimal total = precioVenta.multiply(cantidad);

            System.out.println("Total Calculado: " + total);

            return total;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "CompraProducto{" +
                "compraproducto_id=" + compraproducto_id +
                ", compra_detalle_total=" + compra_detalle_total +
                '}';
    }
}