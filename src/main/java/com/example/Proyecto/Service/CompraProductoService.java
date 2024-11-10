package com.example.Proyecto.Service;

import com.example.Proyecto.Model.CompraProducto;
import com.example.Proyecto.Model.Producto;
import com.example.Proyecto.Repository.CompraProductoRepository;
import com.example.Proyecto.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CompraProductoService {

    @Autowired
    private CompraProductoRepository compraProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los CompraProducto
    public List<CompraProducto> obtenerTodos() {
        return compraProductoRepository.findAll();
    }

    // Buscar
    public CompraProducto obtenerPorId(int id) {
        return compraProductoRepository.findById(id).orElse(null);
    }

    // Guardar
    public CompraProducto guardar(CompraProducto compraProducto) {
        calcularYAsignarTotal(compraProducto);
        restarCantidadProducto(compraProducto);
        return compraProductoRepository.save(compraProducto);
    }

    // Actualizar
    public CompraProducto actualizar(int id, CompraProducto compraProducto) {
        if (compraProductoRepository.existsById(id)) {
            compraProducto.setCompraproducto_id(id);
            calcularYAsignarTotal(compraProducto);
            restarCantidadProducto(compraProducto);
            return compraProductoRepository.save(compraProducto);
        } else {
            throw new RuntimeException("El CompraProducto con ID " + id + " no existe.");
        }
    }

    // Eliminar
    public void eliminar(int id) {
        if (compraProductoRepository.existsById(id)) {
            compraProductoRepository.deleteById(id);
        }
    }

    // Metodo para calcular y asignar el total de una compra
    private void calcularYAsignarTotal(CompraProducto compraProducto) {
        if (compraProducto.getProducto() != null && compraProducto.getProducto().getProducto_id() != 0) {
            Producto producto = productoRepository.findById(compraProducto.getProducto().getProducto_id()).orElse(null);

            if (producto != null) {
                BigDecimal precioVenta = BigDecimal.valueOf(producto.getProducto_precio_venta());
                BigDecimal total = precioVenta.multiply(new BigDecimal(compraProducto.getCompra_detalle_cantidad()));
                compraProducto.setCompra_detalle_total(total);
            } else {
                compraProducto.setCompra_detalle_total(BigDecimal.ZERO);
            }
        } else {
            compraProducto.setCompra_detalle_total(BigDecimal.ZERO);
        }
    }

    // Metodo para restar la cantidad Vendida en el stock del producto
    private void restarCantidadProducto(CompraProducto compraProducto) {
        if (compraProducto.getProducto() != null) {
            Producto producto = productoRepository.findById(compraProducto.getProducto().getProducto_id()).orElse(null);

            if (producto != null) {
                int cantidadDisponible = producto.getProducto_stock_total();
                if (cantidadDisponible >= compraProducto.getCompra_detalle_cantidad()) {
                    producto.setProducto_stock_total(cantidadDisponible - compraProducto.getCompra_detalle_cantidad());
                    productoRepository.save(producto);
                } else {
                    throw new RuntimeException("No hay suficiente stock para realizar la compra.");
                }
            }
        }
    }
}
