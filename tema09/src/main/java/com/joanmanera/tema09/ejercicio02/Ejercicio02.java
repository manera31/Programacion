package com.joanmanera.tema09.ejercicio02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02 {
    public Ejercicio02(){
        Scanner lector = new Scanner(System.in);
        int numero;
        boolean verificado;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < 10; i++){
            do{
                try{
                    System.out.print("Introduce un numero: ");
                    numero = Integer.parseInt(lector.nextLine());
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

            } while (!verificado);
        }

        System.out.println("El numero mas grande ha sido el: "+max);
    }
}
