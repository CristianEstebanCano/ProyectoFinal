package com.example.Parcial.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cajaId;

    @Column(length = 100, nullable = false)
    private String cajaNombre;

    private BigDecimal cajaEfectivo;

    @OneToMany(mappedBy = "caja")
    private List<Venta> ventas;

    // Constructor vacío
    public Caja() {}

    // Constructor lleno
    public Caja(Integer cajaId, String cajaNombre, BigDecimal cajaEfectivo) {
        this.cajaId = cajaId;
        this.cajaNombre = cajaNombre;
        this.cajaEfectivo = cajaEfectivo;
    }

    // Getters y Setters
    public Integer getCajaId() {
        return cajaId;
    }

    public void setCajaId(Integer cajaId) {
        this.cajaId = cajaId;
    }

    public String getCajaNombre() {
        return cajaNombre;
    }

    public void setCajaNombre(String cajaNombre) {
        this.cajaNombre = cajaNombre;
    }

    public BigDecimal getCajaEfectivo() {
        return cajaEfectivo;
    }

    public void setCajaEfectivo(BigDecimal cajaEfectivo) {
        this.cajaEfectivo = cajaEfectivo;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    // Método toString
    @Override
    public String toString() {
        return "Caja{" +
                "cajaId=" + cajaId +
                ", cajaNombre='" + cajaNombre + '\'' +
                ", cajaEfectivo=" + cajaEfectivo +
                '}';
    }
}
