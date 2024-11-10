package com.example.Proyecto.Service;

import com.example.Proyecto.Model.Caja;
import com.example.Proyecto.Repository.CajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CajaService {

    @Autowired
    private CajaRepository cajaRepository;

    //Generar lista de cajas
    public List<Caja> obtenerTodos() {
        return cajaRepository.findAll();
    }

    //Buscar
    public Caja obtenerPorId(int id) {
        return cajaRepository.findById(id).orElse(null);
    }

    //Guardar
    public Caja guardar(Caja caja) {
        return cajaRepository.save(caja);
    }

    //Eliminar caja
    public void eliminar(int id) {
        cajaRepository.deleteById(id);
    }

    //Actualizar caja
    public Caja actualizar(Caja caja) {
        return cajaRepository.save(caja);
    }

    // 5. Obtener el efectivo total de cada caja, ordenado de mayor a menor
    public List<Object[]> obtenerTotalEfectivoPorCaja() {
        return cajaRepository.obtenerTotalEfectivoPorCaja();
    }

    // 5.1 Obtener el conteo de compras por cada caja, ordenado de mayor a menor
    public List<Object[]> obtenerConteoComprasPorCaja() {
        return cajaRepository.obtenerConteoComprasPorCaja();
    }
}
