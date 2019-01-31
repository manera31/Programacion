package com.joanmanera.tema09.ejercicio03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio03 {
    private Scanner lector = new Scanner(System.in);
    private int numero, max = Integer.MIN_VALUE;
    private boolean verificado = true;

    public Ejercicio03(){
        while (verificado){
            pedirNumero();
        }
        if(max != Integer.MIN_VALUE){
            System.out.println("El numero maximo ha sido: "+max);
        } else{
            System.out.println("No has introducido ningun numero.");
        }
    }

    private void pedirNumero(){
        try {
            System.out.print("Introduce un numero: ");
            numero = lector.nextInt();
            lector.nextLine();
            if(numero > max){
                max = numero;
            }
            verificado = true;
        } catch (InputMismatchException e){
            System.out.println("El caracter introducido no es un numero");
            verificado = false;
        } catch (NumberFormatException ne) {
            System.out.println("El caracter introducido no es un numero");
            verificado = false;
        }

    }
}
