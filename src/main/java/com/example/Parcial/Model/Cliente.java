package com.example.Parcial.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteId;

    @Column(length = 30, nullable = false)
    private String clienteNumeroDocumento;

    @Column(length = 50)
    private String clienteNombre;

    @Column(length = 50)
    private String clienteApellido;

    @Column(length = 70)
    private String clienteDireccion;

    @Column(length = 20)
    private String clienteTelefono;

    @Column(length = 50)
    private String clienteEmail;

    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;

    // Constructor vacío
    public Cliente() {}

    // Constructor lleno
    public Cliente(Integer clienteId, String clienteNumeroDocumento, String clienteNombre, String clienteApellido,
                   String clienteDireccion, String clienteTelefono, String clienteEmail) {
        this.clienteId = clienteId;
        this.clienteNumeroDocumento = clienteNumeroDocumento;
        this.clienteNombre = clienteNombre;
        this.clienteApellido = clienteApellido;
        this.clienteDireccion = clienteDireccion;
        this.clienteTelefono = clienteTelefono;
        this.clienteEmail = clienteEmail;
    }

    // Getters y Setters
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNumeroDocumento() {
        return clienteNumeroDocumento;
    }

    public void setClienteNumeroDocumento(String clienteNumeroDocumento) {
        this.clienteNumeroDocumento = clienteNumeroDocumento;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteApellido() {
        return clienteApellido;
    }

    public void setClienteApellido(String clienteApellido) {
        this.clienteApellido = clienteApellido;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    public String getClienteTelefono() {
        return clienteTelefono;
    }

    public void setClienteTelefono(String clienteTelefono) {
        this.clienteTelefono = clienteTelefono;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
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
        return "Cliente{" +
                "clienteId=" + clienteId +
                ", clienteNumeroDocumento='" + clienteNumeroDocumento + '\'' +
                ", clienteNombre='" + clienteNombre + '\'' +
                ", clienteApellido='" + clienteApellido + '\'' +
                ", clienteDireccion='" + clienteDireccion + '\'' +
                ", clienteTelefono='" + clienteTelefono + '\'' +
                ", clienteEmail='" + clienteEmail + '\'' +
                '}';
    }
}
