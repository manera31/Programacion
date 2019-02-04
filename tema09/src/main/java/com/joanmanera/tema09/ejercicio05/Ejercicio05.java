package com.joanmanera.tema09.ejercicio05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio05 {
    private Scanner lector = new Scanner(System.in);
    private String nombre;
    private int edad;
    private float altura;
    private boolean verificado;

    public Ejercicio05(){
        pedirDatos();
        Alumno al1 = new Alumno(nombre, edad, altura);
        pedirDatos();
        Alumno al2 = new Alumno(nombre, edad, altura);

        System.out.println(al1.toString());
        System.out.println(al2.toString());

        if(al1.getEdad() > al2.getEdad()){
            System.out.println("El alumno "+al1.getNombre()+" es mayor");
        } else if (al1.getEdad() < al2.getEdad()) {
            System.out.println("El alumno "+al2.getNombre()+" es mayor");
        } else {
            System.out.println("Los alumnos "+al1.getNombre()+" y "+al2.getNombre()+" tienen la misma edad");
        }

    }
    private void pedirDatos(){
        System.out.println("Introducir datos...");
        System.out.print("Introduce el nombre del alumno: ");
        nombre = lector.nextLine();

        do{
            try{
                System.out.print("Introduce la edad del alumno: ");
                edad = Integer.parseInt(lector.nextLine());
                verificado = true;
            } catch (InputMismatchException e){
                System.out.println("El caracter introducido no es un numero");
                verificado = false;
            } catch (NumberFormatException ne) {
                System.out.println("El caracter introducido no es un numero");
                verificado = false;
            }
        } while (!verificado);

        do{
            try{
                System.out.print("Introduce la altura del alumno: ");
                altura = lector.nextFloat();
                lector.nextLine();
                verificado = true;
            } catch (InputMismatchException e){
                System.out.println("El caracter introducido no es un numero");
                verificado = false;
                lector.nextLine();
            } catch (NumberFormatException ne) {
                System.out.println("El caracter introducido no es un numero");
                verificado = false;
                lector.nextLine();
            }
        } while (!verificado);

    }
}
