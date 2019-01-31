package com.joanmanera.tema08.ejercicio06;

import java.util.Scanner;

public class Ejercicio06 {
    public Ejercicio06() {
        int menu1 = 1;
        int menu2 = 1;
        int contadorDatos = 3;
        int aux, aux2;

        int referencia;
        String marca, modelo;
        char letraAuxiliar;

        Scanner lector = new Scanner(System.in);
        Bicicleta[] datos = new Bicicleta[100];
        datos[0] = new Bicicleta(1, "marca1", "modelo1", 12.2, 24.2, true, "17-01-2018", 300.60, 100);
        datos[1] = new Bicicleta(2, "marca1", "modelo2", 20.3, 26.4, false, "20-08-2018", 120.20, 90);
        datos[2] = new Bicicleta(3, "marca2", "modelo3", 16.8, 21.61, false, "01-10-2018", 99.99, 80);
        datos[3] = new Bicicleta(4, "marca3", "modelo3", 13.7, 24.9, false, "17-01-2019", 80.99, 70);

        while (menu1 != 0) {
            do {
                System.out.print("\u001B[H\u001B[2J");
                menuPrincipal();
                menu1 = lector.nextInt();
                lector.nextLine();
            } while (menu1 < 0 || menu1 > 4);

            if (menu1 != 0) {
                switch (menu1) {
                    case 1:
                        System.out.print("\u001B[H\u001B[2J");
                        System.out.flush();
                        System.out.println(".-Añadir bicicleta-.");

                        System.out.println("Escribe la referencia de la bicicleta: (solo numeros enteros)");
                        referencia = lector.nextInt();
                        lector.nextLine();

                        aux = comprobarReferencia(datos, referencia, contadorDatos);
                        if (aux >= 0) {
                            System.out.println("La referencia ha sido encontrada. Introduce la cantidad de bicicletas que quieres añadir: ");
                            aux2 = lector.nextInt();
                            lector.nextLine();
                            datos[aux].setExistencias(datos[aux].getExistencias() + aux2);
                            System.out.println("Bicicleta/s añadidas correctamente. Ahora hay "+datos[aux].getExistencias()+" en stock");
                        } else if(aux < 0) {
                            System.out.println("La referencia no ha sido encontrada. Quieres añadir una bicicleta con la referencia: "+ referencia+"? Si / No");
                            do {
                                letraAuxiliar = lector.next().charAt(0);
                                lector.nextLine();
                                if (letraAuxiliar == 'S' || letraAuxiliar == 's') {
                                    System.out.println("Añadiendo una nueva bicicleta...");

                                    contadorDatos++;

                                    datos[contadorDatos] = new Bicicleta();

                                    datos[contadorDatos].setReferencia(referencia);

                                    System.out.println("Introduce la marca: ");
                                    datos[contadorDatos].setMarca(lector.nextLine());

                                    System.out.println("Introduce el modelo: ");
                                    datos[contadorDatos].setModelo(lector.nextLine());

                                    System.out.println("Introduce el peso: ");
                                    datos[contadorDatos].setPeso(lector.nextDouble());

                                    System.out.println("Introduce las pulgadas de las ruedas: ");
                                    datos[contadorDatos].setPulgadasRuedas(lector.nextDouble());

                                    do {
                                        System.out.println("Tiene motor? Si / No");
                                        letraAuxiliar = lector.next().charAt(0);
                                        if (letraAuxiliar == 'S' || letraAuxiliar == 's') {
                                            datos[contadorDatos].setHaveMotor(true);
                                        } else {
                                            datos[contadorDatos].setHaveMotor(false);
                                        }
                                        lector.nextLine();
                                    } while (letraAuxiliar != 'S' && letraAuxiliar != 's' && letraAuxiliar != 'N' && letraAuxiliar != 'n');

                                    System.out.println("Introduce la fecha de fabricación: ");
                                    datos[contadorDatos].setFechaFabricacion(lector.nextLine());

                                    System.out.println("Introduce el precio: ");
                                    datos[contadorDatos].setPrecio(lector.nextDouble());

                                    System.out.println("Introduce las existencias: ");
                                    datos[contadorDatos].setExistencias(lector.nextInt());
                                    lector.nextLine();


                                    System.out.println("Bicicleta añadida con exito!");
                                }

                            } while (letraAuxiliar != 'S' && letraAuxiliar != 's' && letraAuxiliar != 'N' && letraAuxiliar != 'n');


                        }
                        System.out.println("\nPulsa intro para continuar...");
                        lector.nextLine();
                        break;
                    case 2:
                        System.out.print("\u001B[H\u001B[2J");
                        System.out.flush();
                        System.out.println(".-Vender bicicleta-.");
                        System.out.print("Escribe la referencia de la bicicleta: ");
                        referencia = lector.nextInt();
                        lector.nextLine();

                        aux = comprobarReferencia(datos, referencia, contadorDatos);
                        if (aux >= 0) {
                            if (datos[aux].getExistencias() > 0){
                                System.out.println("Bicicleta con referencia " + referencia + " encontrada, cuantas quieres vender? max. " + datos[aux].getExistencias());
                                aux2 = 0;
                                do {
                                    if(aux2 > datos[aux].getExistencias() || aux2 < 0){
                                        System.out.println("Numero incorrecto, vuelva a introducir...");
                                    }
                                    aux2 = lector.nextInt();
                                    lector.nextLine();
                                } while (aux2 > datos[aux].getExistencias() || aux2 < 0);

                                datos[aux].setExistencias(datos[aux].getExistencias() - aux2);
                                System.out.println("Bicicletas vendidas con exito! Quedan " + datos[aux].getExistencias());
                            } else {
                                System.out.println("No quedan bicicletas en stock con esta referencia: "+referencia);
                            }
                        } else if(aux < 0) {
                            System.out.println("La referencia no ha sido encontrada. No hay bicicletas con esta referencia: "+referencia);
                        }
                        System.out.println("\nPulsa intro para continuar...");
                        lector.nextLine();
                        break;
                    case 3:
                        while (menu2 != 0) {
                            do {
                                System.out.print("\u001B[H\u001B[2J");
                                System.out.flush();
                                menuConsulta();
                                menu2 = lector.nextInt();
                                lector.nextLine();
                            } while (menu2 < 0 || menu2 > 3);
                            switch (menu2) {
                                case 1:
                                    System.out.println("Consulta por referencia...");
                                    System.out.print("Escribe la referencia de la bicicleta: ");
                                    referencia = lector.nextInt();
                                    lector.nextLine();

                                    aux = comprobarReferencia(datos, referencia, contadorDatos);
                                    if (aux >= 0){
                                        System.out.println("\nBicicleta con referencia: " + datos[aux].getReferencia());
                                        System.out.println("Marca: " + datos[aux].getMarca());
                                        System.out.println("Modelo: " + datos[aux].getModelo());
                                        System.out.println("Peso: " + datos[aux].getPeso());
                                        System.out.println("Pulgadas de la rueda: " + datos[aux].getPulgadasRuedas());
                                        System.out.println("Tiene motor? " + datos[aux].getHaveMotor());
                                        System.out.println("Fecha de fabricacion: " + datos[aux].getFechaFabricacion());
                                        System.out.println("Precio: " + datos[aux].getPrecio());
                                        System.out.println("Numero de existencias: " + datos[aux].getExistencias());

                                    } else if (aux < 0){
                                        System.out.println("No se ha encontrado ninguna bicicleta con esta referencia: " + referencia);
                                    }
                                    System.out.println("\nPulsa intro para continuar...");
                                    lector.nextLine();
                                    break;
                                case 2:
                                    System.out.println("Consulta por marca...");
                                    System.out.print("Escribe la marca de la bicicleta: ");
                                    marca = lector.nextLine();

                                    aux = 0;
                                    for (int i = 0; i <= contadorDatos; i++) {
                                        if (datos[i].getMarca().toLowerCase().equals(marca.toLowerCase())) {
                                            System.out.println("\nBicicleta con referencia: " + datos[i].getReferencia());
                                            System.out.println("Marca: " + datos[i].getMarca());
                                            System.out.println("Modelo: " + datos[i].getModelo());
                                            System.out.println("Peso: " + datos[i].getPeso());
                                            System.out.println("Pulgadas de la rueda: " + datos[i].getPulgadasRuedas());
                                            System.out.println("Tiene motor? " + datos[i].getHaveMotor());
                                            System.out.println("Fecha de fabricacion: " + datos[i].getFechaFabricacion());
                                            System.out.println("Precio: " + datos[i].getPrecio());
                                            System.out.println("Numero de existencias: " + datos[i].getExistencias());
                                            aux++;
                                        }
                                    }
                                    if (aux == 0){
                                        System.out.println("No se han encontrado bicicletas con esta marca: "+ marca);
                                    }
                                    System.out.println("\nPulsa intro para continuar...");
                                    lector.nextLine();
                                    break;
                                case 3:
                                    System.out.println("Consulta por modelo...");
                                    System.out.print("Escribe el modelo de la bicicleta: ");
                                    modelo = lector.nextLine();

                                    aux = 0;
                                    for (int i = 0; i <= contadorDatos; i++) {
                                        if (datos[i].getModelo().toLowerCase().equals(modelo.toLowerCase())) {
                                            System.out.println("\nBicicleta con referencia: " + datos[i].getReferencia());
                                            System.out.println("Marca: " + datos[i].getMarca());
                                            System.out.println("Modelo: " + datos[i].getModelo());
                                            System.out.println("Peso: " + datos[i].getPeso());
                                            System.out.println("Pulgadas de la rueda: " + datos[i].getPulgadasRuedas());
                                            System.out.println("Tiene motor? " + datos[i].getHaveMotor());
                                            System.out.println("Fecha de fabricacion: " + datos[i].getFechaFabricacion());
                                            System.out.println("Precio: " + datos[i].getPrecio());
                                            System.out.println("Numero de existencias: " + datos[i].getExistencias());
                                            aux++;
                                        }
                                    }
                                    if (aux == 0){
                                        System.out.println("No se han encontrado bicicletas con este modelo: "+ modelo);
                                    }
                                    System.out.println("\nPulsa intro para continuar...");
                                    lector.nextLine();
                                    break;
                            }
                        }
                        System.out.println("\nPulsa intro para continuar...");
                        lector.nextLine();
                        break;
                    case 4:
                        System.out.print("\u001B[H\u001B[2J");
                        System.out.flush();

                        System.out.println(".-Mostrar stock-.");
                        for(int i = 0 ; i <= contadorDatos ; i++){
                            System.out.println("Bicicleta con referencia: " + datos[i].getReferencia() + ", " + datos[i].getExistencias() + " unidades");
                        }

                        System.out.println("\nPulsa intro para continuar...");
                        lector.nextLine();
                        break;

                    default:
                        System.out.println("ERROR en la lectura de datos");
                        break;
                }
            }
        }
    }

    private void menuPrincipal() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
        System.out.println("*************************");
        System.out.println("**GESTIÓN DE BICICLETAS**");
        System.out.println("*************************");
        System.out.println("1.- Añadir bicicleta ...");
        System.out.println("2.- Vender bicicleta ...");
        System.out.println("3.- Consultar bicicleta ...");
        System.out.println("4.- Mostrar stock");
        System.out.println("-------------------------");
        System.out.println("0.- Salir");
    }

    private void menuConsulta() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
        System.out.println("**********************");
        System.out.println("**CONSULTA BICICLETA**");
        System.out.println("**********************");
        System.out.println("1.- Consultar por referencia ...");
        System.out.println("2.- Consultar por marca ...");
        System.out.println("3.- Consultar por modelo ...");
        System.out.println("-------------------------");
        System.out.println("0.- Volver al menú principal");
    }

    private int comprobarReferencia(Bicicleta[] datos, int referencia, int contadorDatos) {
        for (int i = 0; i <= contadorDatos; i++) {
            if (datos[i].getReferencia() == referencia) {
                return i;
            }
        }
        return -1;
    }
}
