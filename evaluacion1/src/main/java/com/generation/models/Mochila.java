package com.generation.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mochilas")
public class Mochila {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    @NotNull
    private String modelo;
    @NotNull
    private Integer capacidad;

    //CONSTRUCTORES

    public Mochila() {
    }

    public Mochila(Long id, String color, String modelo, Integer capacidad) {
        this.id = id;
        this.color = color;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    //GET Y SET


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
