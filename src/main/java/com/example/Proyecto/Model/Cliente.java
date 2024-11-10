package com.example.Proyecto.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cliente_id;

    private String cliente_nombre;
    private String cliente_telefono;
    private String cliente_email;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Compra> compras;

    public Cliente() {
    }

    public Cliente(int cliente_id, String cliente_nombre, String cliente_telefono, String cliente_email) {
        this.cliente_id = cliente_id;
        this.cliente_nombre = cliente_nombre;
        this.cliente_telefono = cliente_telefono;
        this.cliente_email = cliente_email;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nombre() {
        return cliente_nombre;
    }

    public void setCliente_nombre(String cliente_nombre) {
        this.cliente_nombre = cliente_nombre;
    }

    public String getCliente_telefono() {
        return cliente_telefono;
    }

    public void setCliente_telefono(String cliente_telefono) {
        this.cliente_telefono = cliente_telefono;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cliente_id=" + cliente_id +
                ", cliente_nombre='" + cliente_nombre + '\'' +
                ", cliente_telefono='" + cliente_telefono + '\'' +
                ", cliente_email='" + cliente_email + '\'' +
                '}';
    }
}