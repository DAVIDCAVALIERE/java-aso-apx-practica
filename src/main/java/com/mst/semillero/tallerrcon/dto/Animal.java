package com.mst.semillero.tallerrcon.dto;

public abstract class Animal {
    private final String nombre;
    private final String raza;
    private final String color;
    private final int edad;
    private final String sexo;

    public Animal(String nombre, String raza, String color, int edad, String sexo) {
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public abstract String hacerSonido();
}
