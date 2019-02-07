package com.joanmanera.tema09.ejercicio10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio10 {
    private int operando1;
    private int operando2;
    private Scanner lector = new Scanner(System.in);
    public Ejercicio10(){
        int numero;
        do{
            numero = menu();
            switch (numero){
                case 1:
                    System.out.println("Suma:");
                    pedirDatos();
                    System.out.println("Resultado: "+(operando1+operando2));
                    break;
                case 2:
                    System.out.println("Resta:");
                    pedirDatos();
                    System.out.println("Resultado: "+(operando1-operando2));
                    break;
                case 3:
                    System.out.println("Multiplicación:");
                    pedirDatos();
                    System.out.println("Resultado: "+(operando1*operando2));
                    break;
                case 4:
                    System.out.println("División:");
                    pedirDatos();
                    System.out.println("Resultado: "+(operando1/operando2));
                    break;
                case 5:
                    System.out.println("Resto de la división:");
                    pedirDatos();
                    System.out.println("Resultado: "+(operando1%operando2));
                    break;

            }
            System.out.println();
            System.out.println("Pulsa intro para continuar...");
            lector.nextLine();
            System.out.print("\u001B[H\u001B[2J");
            System.out.flush();

        } while (numero != 0);
    }
    private void pedirDatos(){
        boolean verificado;
        do{
            try{
                System.out.print("Introduce el operando 1: ");
                operando1 = lector.nextInt();
                lector.nextLine();
                verificado = true;
            } catch (InputMismatchException ime){
                System.out.println("Carácter no válido, intentelo de nuevo");
                lector.nextLine();
                verificado = false;
            }

        } while (!verificado);

        do{
            try{
                System.out.print("Introduce el operando 2: ");
                operando2 = lector.nextInt();
                lector.nextLine();
                verificado = true;
            } catch (InputMismatchException ime){
                System.out.println("Carácter no válido, intentelo de nuevo");
                lector.nextLine();
                verificado = false;
            }

        } while (!verificado);
    }
    private int menu(){
        int numero;

        System.out.println("**Calculadora básica**\n");
        System.out.println("Elige una opción:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Resto división");
        System.out.println("-------------------");
        System.out.println("0.Salir");
        do{
            numero = lector.nextInt();
            lector.nextLine();
            if (numero<0 || numero>5) {
                System.out.println("No hay ninguna operación con este número. Vuelve a intentarlo.");
            }
        } while (numero<0 || numero>5);
        return numero;
    }
}

