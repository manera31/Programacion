package com.joanmanera.tema09.ejercicio04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio04 {

    public Ejercicio04(){
        System.out.println("Array de 5 números enteros");
        int[] array = new int[5];
        try {
            introducirNumerosArray(array);
        } catch (NullPointerException npe){
            System.out.println("El array no esta inicializado");
        } catch (IndexOutOfBoundsException iobe){
            System.out.println("El array esta lleno y no se ha guardado el último número");
            System.out.println(Arrays.toString(array));
        }



        System.out.println("\nArray sin inicializar");
        array = null;
        try {
            introducirNumerosArray(array);
        } catch (NullPointerException npe){
            System.out.println("El array no está inicializado");
        } catch (IndexOutOfBoundsException iobe){
            System.out.println("El array esta lleno y no se ha guardado el último número");
        }

    }

    public void introducirNumerosArray(int[] array){
        Scanner lector = new Scanner(System.in);
        boolean verificado;

        for(int i = 0 ; i < 100 ; i++){
            do{
                try{
                    System.out.print("Introduce un numero: ");
                    array[i] = Integer.parseInt(lector.nextLine());
                    verificado = true;
                } catch (InputMismatchException e){
                    System.out.println("El caracter introducido no es un número");
                    verificado = false;
                } catch (NumberFormatException ne) {
                    System.out.println("El caracter introducido no es un número");
                    verificado = false;
                }

            } while (!verificado);
        }
    }
}
