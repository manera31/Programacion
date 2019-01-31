package com.joanmanera.tema09.ejercicio05;

public class Alumno {
    private String nombre;
    private int edad;
    private float altura;

    public Alumno( String nombre, int edad, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getAltura() {
        return altura;
    }
}
