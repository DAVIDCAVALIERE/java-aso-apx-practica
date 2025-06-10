package com.mst.semillero.tallerrcon.dto;

public class Gato extends Animal {
    private final double peso;
    private final double longitud;
    private final String tipoMaullido;
    private final int nivelCaza;

    public Gato(String nombre, String raza, String color, int edad, String sexo) {
        super(nombre, raza, color, edad, sexo);
        this.peso = 4.5;
        this.longitud = 45.0;
        this.tipoMaullido = "suave";
        this.nivelCaza = 8;
    }

    public double getPeso() {
        return peso;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getTipoMaullido() {
        return tipoMaullido;
    }

    public int getNivelCaza() {
        return nivelCaza;
    }

    @Override
    public String hacerSonido() {
        return "Miau";
    }
}
