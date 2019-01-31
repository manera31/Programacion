package com.joanmanera.tema08.ejercicio05;

public class Ejercicio05 {
    public Ejercicio05(){
        Punto p1 = new Punto(4.3, 7.7);

        Circulo c1 = new Circulo();
        Circulo c2 = new Circulo(p1, 3.7);
        Circulo c3 = new Circulo(6.4, 2.9, 1.6);
        Circulo c4 = new Circulo(0, 0, 2.5);

        System.out.println("Circulo 1: ");
        c1.mostrarCirculo();
        System.out.printf("Perimetro = %.2f\n", c1.calcularPerimetro());
        System.out.printf("Area = %.2f\n\n", c1.calcularArea());

        System.out.println("Circulo 2: ");
        c2.mostrarCirculo();
        System.out.printf("Perimetro = %.2f\n", c2.calcularPerimetro());
        System.out.printf("Area = %.2f\n\n", c2.calcularArea());

        System.out.println("Circulo 3: ");
        c3.mostrarCirculo();
        System.out.printf("Perimetro = %.2f\n", c3.calcularPerimetro());
        System.out.printf("Area = %.2f\n\n", c3.calcularArea());

        System.out.println("Circulo 4: ");
        c4.mostrarCirculo();
        System.out.printf("Perimetro = %.2f\n", c4.calcularPerimetro());
        System.out.printf("Area = %.2f\n\n", c4.calcularArea());

        System.out.printf("La distancia entre el Circulo 1 y Circulo 2 es: %.2f\n", c1.calcularDistancia(c2.getPunto()));
        System.out.printf("La distancia entre el Circulo 1 y Circulo 3 es: %.2f\n", c1.calcularDistancia(c3.getPunto()));
        System.out.printf("La distancia entre el Circulo 1 y Circulo 4 es: %.2f\n", c1.calcularDistancia(c4.getPunto()));
        System.out.printf("La distancia entre el Circulo 2 y Circulo 3 es: %.2f\n", c2.calcularDistancia(c3.getPunto()));
        System.out.printf("La distancia entre el Circulo 2 y Circulo 4 es: %.2f\n", c2.calcularDistancia(c4.getPunto()));
        System.out.printf("La distancia entre el Circulo 3 y Circulo 4 es: %.2f\n", c3.calcularDistancia(c4.getPunto()));
    }
}
