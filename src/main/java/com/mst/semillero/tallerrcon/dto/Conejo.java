package com.mst.semillero.tallerrcon.dto;

public class Conejo extends Animal {
    private final double peso;
    private final double longitudOrejas;
    private final double velocidadSalto;
    private final String tipoAlimentacion;

    public Conejo(String nombre, String raza, String color, int edad, String sexo) {
        super(nombre, raza, color, edad, sexo);
        this.peso = 2.5;
        this.longitudOrejas = 12.0;
        this.velocidadSalto = 35.0;
        this.tipoAlimentacion = "herbívoro";
    }

    public double getPeso() {
        return peso;
    }

    public double getLongitudOrejas() {
        return longitudOrejas;
    }

    public double getVelocidadSalto() {
        return velocidadSalto;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    @Override
    public String hacerSonido() {
        return "zzzzz";
    }
}
