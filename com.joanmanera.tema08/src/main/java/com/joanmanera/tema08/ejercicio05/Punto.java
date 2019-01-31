package com.joanmanera.tema08.ejercicio05;

import java.util.Random;

public class Punto {
    private double x;
    private double y;
    private Random rand = new Random();

    public Punto(){
        this.x = 1 + (20 - 1) * rand.nextDouble();
        this.y = 1 + (20 - 1) * rand.nextDouble();

    }
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double calcularDistancia(Punto punto){
        return Math.hypot((x - punto.getX()), (y - punto.getY()));
    }
    public void mostrarPunto(){
        System.out.printf("(%.1f, %.1f)\n", x, y);
    }
}
