package com.joanmanera.tema09.ejercicio01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio01 {
    public Ejercicio01(){
        int numero = 1;
        boolean verificado;
        Scanner lector = new Scanner(System.in);

        while (numero > 0 ) {

            do{
                try{
                    System.out.print("Introduce un numero: ");
                    numero = Integer.parseInt(lector.nextLine());
                    verificado = true;
                } catch (InputMismatchException e){
                    System.out.println("El caracter introducido no es un numero");
                    verificado = false;
                } catch (NumberFormatException ne) {
                    System.out.println("El caracter introducido no es un numero");
                    verificado = false;
                }

            } while (!verificado);
        }
    }
}
