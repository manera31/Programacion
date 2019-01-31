package com.joanmanera.practica02;

import java.util.Scanner;
import java.util.Random;

//Esta es la libreria que utilizo. En ella tengo métodos para limpiar la pantalla y para generar numeros aleatorios.
public class Lib {
    private static Scanner lector = new Scanner(System.in);

    private static Random rdn = new Random();

    public static void limpiarPantallaConMensaje() {
        System.out.println();
        System.out.println("Pulsa intro para continuar...");
        lector.nextLine();
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static void limpiarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static int randomAleatorio(int min, int max) {
        return rdn.nextInt(max - min + 1) + min;
    }

    public static int randomAleatorio(int num) {
        return rdn.nextInt(num);
    }
}