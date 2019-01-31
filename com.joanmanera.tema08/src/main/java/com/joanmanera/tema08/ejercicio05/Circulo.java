package com.joanmanera.tema08.ejercicio05;

import java.util.Random;

public class Circulo {
    private Random rand = new Random();
    private Punto punto;
    private double radio;

    public Circulo(Punto punto, double radio){
        this.punto = punto;
        this.radio = radio;
    }
    public Circulo(double x, double y, double radio){
        this.punto = new Punto(x, y);
        this.radio = radio;
    }
    public Circulo(){
        this.punto = new Punto();
        this.radio = 1 + (5 - 1) * rand.nextDouble();
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }
    public double calcularDistancia(Punto punto2){
        return Math.hypot((this.punto.getX() - punto2.getX()), (this.punto.getY() - punto2.getY()));
    }
    public double calcularArea(){
        return Math.PI * (radio * radio);
    }
    public double calcularPerimetro(){
        return (2 * Math.PI)* radio ;
    }
    public void mostrarCirculo(){
        if(this.punto.getX() == 0 && this.punto.getY() == 0){
            System.out.printf("Circulo de radio %.1f cm situado en el origen de las coordenadas\n", radio);
        }else {
            System.out.printf("Circulo de radio %.1f cm situado en el punto (%.1f, %.1f)\n", radio, this.punto.getX(), this.punto.getY());
        }
    }
}
