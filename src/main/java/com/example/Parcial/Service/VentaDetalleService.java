package com.example.Parcial.Service;

import com.example.Parcial.Model.VentaDetalle;
import com.example.Parcial.Repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaDetalleService {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    public List<VentaDetalle> obtenerTodos() {
        return ventaDetalleRepository.findAll();
    }

    public VentaDetalle obtenerPorId(Integer id) {
        return ventaDetalleRepository.findById(id).orElse(null);
    }

    public VentaDetalle guardar(VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }

    public void eliminar(Integer id) {
        ventaDetalleRepository.deleteById(id);
    }
}
