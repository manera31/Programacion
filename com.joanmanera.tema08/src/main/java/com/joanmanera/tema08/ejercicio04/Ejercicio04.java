package com.joanmanera.tema08.ejercicio04;

public class Ejercicio04 {
    public Ejercicio04(){
        Punto p1 = new Punto();
        Punto p2 = new Punto(6.9, 5.2);
        Punto p3 = new Punto();

        p1.mostrarPunto();
        p2.mostrarPunto();
        p3.mostrarPunto();

        System.out.printf("Distancia entre p1 y p2 : %.2f\n",p1.calcularDistancia(p2));
        System.out.printf("Distancia entre p1 y p3 : %.2f\n",p1.calcularDistancia(p3));
        System.out.printf("Distancia entre p2 y p3 : %.2f\n",p2.calcularDistancia(p3));
    }
}
