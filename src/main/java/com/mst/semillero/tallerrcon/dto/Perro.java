package com.mst.semillero.tallerrcon.dto;

public class Perro extends Animal {
    private final double peso;
    private final double altura;
    private final int nivelEntrenamiento;
    private final boolean esGuardian;

    public Perro(String nombre, String raza, String color, int edad, String sexo) {
        super(nombre, raza, color, edad, sexo);
        this.peso = 25.0;
        this.altura = 60.0;
        this.nivelEntrenamiento = 7;
        this.esGuardian = true;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public int getNivelEntrenamiento() {
        return nivelEntrenamiento;
    }

    public boolean isEsGuardian() {
        return esGuardian;
    }

    @Override
    public String hacerSonido() {
        return "Guau";
    }
}
