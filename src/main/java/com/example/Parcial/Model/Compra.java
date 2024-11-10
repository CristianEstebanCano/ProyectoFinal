package com.example.Parcial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compra_id;

    private Date compra_fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "caja_id")
    private Caja caja;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CompraProducto> productos;

    public Compra() {
    }

    public Compra(int compra_id, Date compra_fecha, Cliente cliente, Caja caja) {
        this.compra_id = compra_id;
        this.compra_fecha = compra_fecha;
        this.cliente = cliente;
        this.caja = caja;
    }

    public int getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(int compra_id) {
        this.compra_id = compra_id;
    }

    public Date getCompra_fecha() {
        return compra_fecha;
    }

    public void setCompra_fecha(Date compra_fecha) {
        this.compra_fecha = compra_fecha;
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

    public List<CompraProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<CompraProducto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "compra_id=" + compra_id +
                ", compra_fecha=" + compra_fecha +
                '}';
    }
}