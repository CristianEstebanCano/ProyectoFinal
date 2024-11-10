package com.example.Proyecto.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caja_id;

    private String caja_nombre;

    @OneToMany(mappedBy = "caja")
    @JsonIgnore
    private List<Compra> compras;

    public Caja() {
    }

    public Caja(int caja_id, String caja_nombre) {
        this.caja_id = caja_id;
        this.caja_nombre = caja_nombre;
    }

    public int getCaja_id() {
        return caja_id;
    }

    public void setCaja_id(int caja_id) {
        this.caja_id = caja_id;
    }

    public String getCaja_nombre() {
        return caja_nombre;
    }

    public void setCaja_nombre(String caja_nombre) {
        this.caja_nombre = caja_nombre;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "caja_id=" + caja_id +
                ", caja_nombre='" + caja_nombre + '\'' +
                '}';
    }
}
