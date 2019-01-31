package com.joanmanera.tema08.ejercicio04;

import java.util.Random;

public class Punto {
    private double x;
    private double y;
    private Random rand = new Random();

    public Punto(){
        this.setX(1 + (10 - 1) * rand.nextDouble());
        this.setY(1 + (10 - 1) * rand.nextDouble());

    }
    public Punto(double x, double y){
        this.setX(x);
        this.setY(y);
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
