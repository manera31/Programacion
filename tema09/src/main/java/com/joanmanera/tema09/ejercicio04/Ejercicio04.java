package com.joanmanera.tema09.ejercicio04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio04 {

    public Ejercicio04(){
        int[] array = new int[5];
        try {
            introducirNumerosArray(array);
        } catch (NullPointerException npe){
            System.out.println("El array no esta inicializado");
        } catch (IndexOutOfBoundsException iobe){
            System.out.println("El array esta lleno");
            Arrays.toString(array);
        }

    }

    public void introducirNumerosArray(int[] array){
        Scanner lector = new Scanner(System.in);
        boolean verificado = false;

        for(int i = 0 ; i < 100 ; i++){
            do{
                try{
                    System.out.print("Introduce un numero: ");
                    array[i] = Integer.parseInt(lector.nextLine());
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
