package com.example.Parcial.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Venta {

    @Id
    @Column(length = 200, nullable = false)
    private String ventaId;

    private LocalDate ventaFecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "caja_id", nullable = false)
    private Caja caja;

    @OneToMany(mappedBy = "venta")
    private List<VentaDetalle> ventaDetalles;

    // Constructor vacío
    public Venta() {}

    // Constructor lleno
    public Venta(String ventaId, LocalDate ventaFecha, Cliente cliente, Caja caja) {
        this.ventaId = ventaId;
        this.ventaFecha = ventaFecha;
        this.cliente = cliente;
        this.caja = caja;
    }

    // Getters y Setters
    public String getVentaId() {
        return ventaId;
    }

    public void setVentaId(String ventaId) {
        this.ventaId = ventaId;
    }

    public LocalDate getVentaFecha() {
        return ventaFecha;
    }

    public void setVentaFecha(LocalDate ventaFecha) {
        this.ventaFecha = ventaFecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
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
        return "Venta{" +
                "ventaId='" + ventaId + '\'' +
                ", ventaFecha=" + ventaFecha +
                ", cliente=" + cliente +
                ", caja=" + caja +
                '}';
    }
}
