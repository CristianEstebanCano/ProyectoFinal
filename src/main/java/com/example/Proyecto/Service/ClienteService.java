package com.example.Proyecto.Service;

import com.example.Proyecto.Model.Cliente;
import com.example.Proyecto.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    //Buscar
    public Cliente obtenerPorId(int id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    //Guardar
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Actualizar
    public Cliente actualizar(int id, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setCliente_nombre(clienteActualizado.getCliente_nombre());
            cliente.setCliente_telefono(clienteActualizado.getCliente_telefono());
            cliente.setCliente_email(clienteActualizado.getCliente_email());

            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    //Eliminar
    public void eliminar(int id) {
        clienteRepository.deleteById(id);
    }

    // 1.1 Conteo compras por cliente ordenado
    public List<Object[]> obtenerConteoComprasPorCliente() {
        return clienteRepository.obtenerConteoComprasPorCliente();
    }
}
