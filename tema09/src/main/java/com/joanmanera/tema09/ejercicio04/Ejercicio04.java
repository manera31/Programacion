package com.joanmanera.tema09.ejercicio04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio04 {

    public Ejercicio04(){
        int[] array = new int[5];
        try {
            introducirNumerosArray(array);
        } catch (IndexOutOfBoundsException iobe){
            System.out.println("El array esta lleno");

        }

    }

    public void introducirNumerosArray(int[] array){
        Scanner lector = new Scanner(System.in);

        for(int i = 0 ; i < array.length ; i++){
            try {
                System.out.print("Introduce un numero: ");
                array[i] = lector.nextInt();
                lector.nextLine();

            } catch (InputMismatchException e){
                System.out.println("El caracter introducido no es un numero");
                i = i - 1;
            } catch (NumberFormatException ne) {
                System.out.println("El caracter introducido no es un numero");
                i = i - 1;
            }
        }
    }
}
