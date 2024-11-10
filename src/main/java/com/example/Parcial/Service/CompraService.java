package com.example.Parcial.Service;

import com.example.Parcial.Model.Compra;
import com.example.Parcial.Repository.CompraRepository;
import com.example.Parcial.Repository.CompraProductoRepository;
import com.example.Parcial.Repository.ClienteRepository;
import com.example.Parcial.Repository.CajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CompraProductoRepository compraProductoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CajaRepository cajaRepository;

    // Obtener todas las compras
    public List<Compra> obtenerTodos() {
        return compraRepository.findAll();
    }

    // Buscar
    public Compra obtenerPorId(int id) {
        Optional<Compra> compra = compraRepository.findById(id);
        return compra.orElse(null); // Retorna null si no existe la compra
    }

    // Guardar
    public Compra guardar(Compra compra) {
        Compra compraGuardada = compraRepository.save(compra);
        return compraGuardada;
    }

    // Actualizar
    public Compra actualizar(Compra compra) {
        if (compraRepository.existsById(compra.getCompra_id())) {
            return compraRepository.save(compra);
        }
        return null;
    }

    // Eliminar
    public void eliminar(int id) {
        if (compraRepository.existsById(id)) {
            compraRepository.deleteById(id);
        }
    }

    // 1. Obtener las compras de un cliente y las cajas asociadas
    public List<Object[]> obtenerComprasPorCliente(int clienteId) {
        return compraRepository.findComprasByCliente(clienteId);
    }

    // 3. Obtener todas las compras de un cliente con sus detalles, organizadas por fecha
    public List<Object[]> obtenerComprasConDetallesPorCliente(int clienteId) {
        return compraRepository.findComprasConDetallesByCliente(clienteId);
    }

    // 4. Obtener todas las compras con detalles, enlazando todas las tablas
    public List<Object[]> obtenerTodasLasComprasConDetalles() {
        return compraRepository.findAllComprasConDetalles();
    }
}
