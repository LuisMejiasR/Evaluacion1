package com.generation.services;

import com.generation.models.Mochila;
import com.generation.repositories.MochilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MochilaService {
    //inyeccion de dependencias
    @Autowired
    MochilaRepository mochilaRepository;

    //guardar mochila
    public void saveMochila(Mochila mochila){
        mochilaRepository.save(mochila);
    }

    //obtener la lista de mochilas
    public List<Mochila> findAll() {
        return mochilaRepository.findAll();
    }
}
