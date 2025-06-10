package com.mst.semillero.tallerrcon.dto;

public abstract class Animal {
    private String nombre;

    public Animal (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public abstract String hacerSonido();
}
