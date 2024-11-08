package com.example.Parcial.Service;

import com.example.Parcial.Model.Caja;
import com.example.Parcial.Repository.CajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CajaService {

    @Autowired
    private CajaRepository cajaRepository;

    public List<Caja> obtenerTodas() {
        return cajaRepository.findAll();
    }

    public Caja obtenerPorId(Integer id) {
        return cajaRepository.findById(id).orElse(null);
    }

    public Caja guardar(Caja caja) {
        return cajaRepository.save(caja);
    }

    public void eliminar(Integer id) {
        cajaRepository.deleteById(id);
    }
}
