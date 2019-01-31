package com.joanmanera.practica02;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Principal {
    private static Scanner lector = new Scanner(System.in); // Creo un nuevo scanner para que se pueda utilizar en toda
                                                            // la clase
    private static int contadorTiradas; // Aqui se guardará el número de tiradas que ha sido necesario hasta llegar al
                                        // premio. Lo defino fuera porque lo utilizo en varios métodos.
    private static Administracion administracion = new Administracion(); // Creo un objeto nuevo de la clase
                                                                         // Administracion. Este lo utilizaré siempre.
    private static GregorianCalendar fecha1, fecha2; // Creo un GregorianCalendar para poder controlar el tiempo que
                                                     // tarda en hacer los sorteos.

    public static void main(String[] args) {
        /*
         * El método main muestra el mensaje de bienvenida y seguido llama al método de
         * introducir el número para jugar. Después de esto limpia la pantalla y muestra
         * las diferentes opciones del juego. Esto se repite hasta que el jugador quiera
         * salir del juego.
         */
        Lib.limpiarPantalla();
        System.out.println("***************************************************");
        System.out.println("*** .-- Bienvenido al juego de la primitiva --. ***");
        System.out.println("***************************************************\n");

        introducirNumero();
        Lib.limpiarPantallaConMensaje();

        int opcionMenuPrincipal;
        do {
            opcionMenuPrincipal = menuPrincipal();
            switch (opcionMenuPrincipal) {
            case 0:
                System.out.println("Hasta pronto!!");
                break;
            case 1:
                opcion1();
                break;
            case 2:
                opcion2();
                break;
            case 3:
                opcion3();
                break;
            case 4:
                opcion4();
                break;
            case 5:
                opcion5();
                break;
            case 6:
                introducirNumero();
                break;
            case 7:
                verBoletoJugador();
                break;
            case 8:
                verPremios();
                break;

            default:
                break;
            }
            Lib.limpiarPantallaConMensaje();
        } while (opcionMenuPrincipal != 0);
    }

    private static int menuPrincipal() {
        /*
         * Este método muestra el menú principal. Muestra por pantalla el menú y pide al
         * juagdor un número de este. El método comprueba que el número introducido por
         * el jugador este dentro de las opciones validas. Finalmente devuelve este
         * número.
         */
        int opcion;
        do {
            Lib.limpiarPantalla();
            System.out.println("************");
            System.out.println("*** Menú ***");
            System.out.println("************");
            System.out.println();
            System.out.println("1. Juego único");
            System.out.println("2. Jugar hasta obtener premio");
            System.out.println("3. Jugar hasta obtener premio sin reintegro");
            System.out.println("4. Ciclo de sorteos");
            System.out.println("5. Jugar hasta obtener premio de la categoria especial");
            System.out.println("--------");
            System.out.println("6. Cambiar el número del boleto");
            System.out.println("7. Ver tu boleto");
            System.out.println("8. Ver los premios aproximados (promedio 2016)");
            System.out.println("--------");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Introduce una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();
        } while (opcion < 0 || opcion > 8);
        return opcion;
    }

    private static void introducirNumero() {
        /*
         * Este método lo utilizo para darle la opción al usuario de introducir él el
         * número del boleto que quiere jugar o que se genere aleatoriamete. El metodo
         * valida que la combnacion que introduce el jugador no se repite. Finalmente
         * muestra por pantalla el boleto del jugador.
         */
        char aux;
        int[] numeroIntroducido = new int[6];
        int[] numerosQueHanSalido = new int[6];
        boolean aux2;
        int contadorNumeros = 0;

        do {
            System.out.print("¿Quieres elegir tú el número o prefieres que se genere aleatoriamente? (Si / No): ");
            aux = lector.nextLine().charAt(0);
        } while (aux != 'n' && aux != 'N' && aux != 's' && aux != 'S');

        if (aux == 'S' || aux == 's') {
            System.out.println("\nIntroduce tu combinación. Debe tener 6 números del 1 al 49 y no se pueden repetir");

            for (int i = 0; i < 6; i++) {
                do {
                    System.out.print("Introduce el número " + (i + 1) + ": ");
                    numeroIntroducido[i] = lector.nextInt();
                    lector.nextLine();
                } while (numeroIntroducido[i] < 1 || numeroIntroducido[i] > 49);

                aux2 = false;
                for (int x = 0; x < numerosQueHanSalido.length; x++) {
                    if (numeroIntroducido[i] == numerosQueHanSalido[x]) {
                        aux2 = true;
                    }
                }

                if (aux2) {
                    i = i - 1;
                } else {
                    numerosQueHanSalido[contadorNumeros] = numeroIntroducido[i];
                    contadorNumeros++;
                }
            }

            administracion.comprarBoleto(numeroIntroducido);

            System.out.println();

        } else {
            System.out.println("\nGenerando boleto...");
            administracion.comprarBoleto();
        }

        verBoletoJugador();
    }

    private static void opcion1() {
        /*
         * Este método es la primera opción del menú. Genera un nuevo sorteo, comprueba
         * el boleto, si el boleto tiene premio lo puestra y finalmente muestra los dos
         * boletos, el del jugador y el boleto ganador.
         */

        Lib.limpiarPantalla();
        System.out.println("JUEGO ÚNICO");
        System.out.println("-----------");
        System.out.println();

        fecha1 = new GregorianCalendar();
        administracion.generarSorteo();

        administracion.mostrarPremio(administracion.comprobarBoleto());

        verLosDosBoletos();

        fecha2 = new GregorianCalendar();
        System.out.println("El tiempo transcurrido ha sido de: "
                + convertirTiempo(fecha2.getTimeInMillis() - fecha1.getTimeInMillis()));
    }

    private static void opcion2() {
        /*
         * Este método corresponde con la segunda opción del menú. Genera un sorteo y
         * comprueba el boleto. Comprueba el código del premio (0 = no premio), si tiene
         * premio lo muestra y si no lo tiene, suma uno al contador de tiradas y repite
         * el proceso hasta que encuentre una combinación ganadora.
         */

        int codigoAciertos = 0;

        Lib.limpiarPantalla();
        System.out.println("JUGAR HASTA OBTENER PREMIO");
        System.out.println("--------------------------");
        System.out.println();

        fecha1 = new GregorianCalendar();
        contadorTiradas = 1;
        while (codigoAciertos == 0) {

            administracion.generarSorteo();
            codigoAciertos = administracion.comprobarBoleto();

            if (codigoAciertos != 0) {
                verLosDosBoletos();
                System.out.println("El boleto ha sido premiado en la tirada número: " + contadorTiradas);
                administracion.mostrarPremio(codigoAciertos);
            } else {
                contadorTiradas++;
            }
        }
        fecha2 = new GregorianCalendar();
        System.out.println("El tiempo transcurrido ha sido de: "
                + convertirTiempo(fecha2.getTimeInMillis() - fecha1.getTimeInMillis()));
    }

    private static void opcion3() {
        /*
         * Este método es la opción 3 del menú. Este hace lo mismo el el anterior pero
         * con la diferencia de que este no considera el reintegro como premio.
         * 
         */
        int codigoAciertos = 0;

        Lib.limpiarPantalla();
        System.out.println("JUGAR HASTA OBTENER PREMIO SIN REINTEGRO");
        System.out.println("----------------------------------------");
        System.out.println();

        fecha1 = new GregorianCalendar();
        contadorTiradas = 1;
        while (codigoAciertos == 0 || codigoAciertos == 7) {

            administracion.generarSorteo();
            codigoAciertos = administracion.comprobarBoleto();
            if (codigoAciertos > 0 && codigoAciertos < 7) {
                verLosDosBoletos();
                System.out.println("El boleto ha sido premiado en la tirada número: " + contadorTiradas);
                administracion.mostrarPremio(codigoAciertos);
            } else {
                contadorTiradas++;
            }
        }
        fecha2 = new GregorianCalendar();
        System.out.println("El tiempo transcurrido ha sido de: "
                + convertirTiempo(fecha2.getTimeInMillis() - fecha1.getTimeInMillis()));
    }

    private static void opcion4() {
        /*
         * Este método corresponde con la opción 4 del menú. Este primero pide al
         * jugador que introduzca el número de sorteos que quiera entre unos rangos.
         * Después empieza a hacer los sorteos y guarda en unas variables los premios.
         * Finalmente los muestra por pantalla y le pregunta al jugador que si desea
         * repetir la jugada.
         */
        int numeroCiclos;
        char aux;
        int codigoAciertos;

        Lib.limpiarPantalla();
        System.out.println("CICLO DE SORTEOS");
        System.out.println("----------------");
        System.out.println();

        do {
            System.out.print("-Escribe el número del ciclo del ciclo de sorteo ente 1 y 1.000.000.000 (sin '.'): ");
            numeroCiclos = lector.nextInt();
            lector.nextLine();
        } while (numeroCiclos < 1 || numeroCiclos > 1000000000);

        do {
            fecha1 = new GregorianCalendar();
            int contadorPremio5 = 0;
            int contadorPremio4 = 0;
            int contadorPremio3 = 0;
            int contadorPremio2 = 0;
            int contadorPremio1 = 0;
            int contadorPremioEspecial = 0;
            int contadorPremioReintegro = 0;

            System.out.println("\nGenerando " + numeroCiclos + " sorteos...\n");
            for (int i = 0; i < numeroCiclos; i++) {
                administracion.generarSorteo();
                codigoAciertos = administracion.comprobarBoleto();
                switch (codigoAciertos) {
                case 1:
                    contadorPremio5++;
                    break;
                case 2:
                    contadorPremio4++;
                    break;
                case 3:
                    contadorPremio3++;
                    break;
                case 4:
                    contadorPremio2++;
                    break;
                case 5:
                    contadorPremio1++;
                    break;
                case 6:
                    contadorPremioEspecial++;
                    break;
                case 7:
                    contadorPremioReintegro++;
                    break;

                default:
                    break;
                }

            }
            System.out.println("Los premios son: ");
            System.out.println("Premio especial: " + contadorPremioEspecial);
            System.out.println("1r premio: " + contadorPremio1);
            System.out.println("2º premio: " + contadorPremio2);
            System.out.println("3r premio: " + contadorPremio3);
            System.out.println("4º premio: " + contadorPremio4);
            System.out.println("5º premio: " + contadorPremio5);
            System.out.println("Premio reintegro: " + contadorPremioReintegro);
            System.out.println("Beneficio: " + ((contadorPremioReintegro + (contadorPremio5 * 8)
                    + (contadorPremio4 * 73) + (contadorPremio3 * 2627) + (contadorPremio2 * 64534)
                    + (contadorPremio1 * 1468716) + (contadorPremioEspecial * 53235749) - numeroCiclos)));

            fecha2 = new GregorianCalendar();
            System.out.println("El tiempo transcurrido ha sido de: "
                    + convertirTiempo(fecha2.getTimeInMillis() - fecha1.getTimeInMillis()));

            do {
                System.out.print("\n¿Deseas volver a repetir el mismo ciclo? Si o No : ");
                aux = lector.nextLine().charAt(0);
            } while (aux != 'n' && aux != 'N' && aux != 's' && aux != 'S');
        } while (aux == 's' || aux == 'S');
    }

    private static void opcion5() {
        /*
         * Este método corresponde con la opcion 5 del menú. Este es igual que el 2 y el
         * 3 pero con la diferencia de que este solo parará cuando encuentre un premio
         * de categoria especial.
         */
        int codigoAciertos = 0;

        Lib.limpiarPantalla();
        System.out.println("JUGAR HASTA GANAR UN PREMIO ESPECIAL");
        System.out.println("------------------------------------");
        System.out.println();

        System.out.println("Generando sorteos...");
        fecha1 = new GregorianCalendar();

        contadorTiradas = 1;
        while (codigoAciertos != 6) {

            administracion.generarSorteo();
            codigoAciertos = administracion.comprobarBoleto();
            if (codigoAciertos == 6) {
                administracion.mostrarPremio(codigoAciertos);
            } else {
                contadorTiradas++;
            }
        }

        verLosDosBoletos();
        System.out.println("\nEl boleto ha sido premiado en la tirada número: " + contadorTiradas);

        fecha2 = new GregorianCalendar();
        System.out.println("El tiempo transcurrido ha sido de: "
                + convertirTiempo(fecha2.getTimeInMillis() - fecha1.getTimeInMillis()));

    }

    private static void verBoletoJugador() {
        // Este método muestra por pantalla el boleto del jugador con formato.

        int[] numeroJugador = administracion.getBoleto().getNumero();
        ordenarArray(numeroJugador);

        System.out.println("\n******************************************");
        System.out.printf("*%25s%16s\n", "TU BOLETO", "*");
        System.out.printf("*%41s\n", "*");
        System.out.printf("*%10s", "Número: ");
        for (int i = 0; i < numeroJugador.length; i++) {
            if (i == (numeroJugador.length - 1)) {
                System.out.printf("%2d", numeroJugador[i]);
            } else {
                System.out.printf("%2d-", numeroJugador[i]);
            }
        }
        System.out.printf("%14s\n", "*");

        System.out.printf("*%13s%2d%26s\n", "Reintegro: ", administracion.getBoleto().getReintegro(), "*");
        System.out.printf("*%41s\n", "*");
        System.out.printf("*%41s\n", "*");
        System.out.println("******************************************");

    }

    private static void verLosDosBoletos() {
        // Este método muestra por pantalla el boleto del jugador y el boleto ganador
        // con formato.

        int[] numeroGanador = administracion.getSorteo().getNumeroGanador();
        ordenarArray(numeroGanador);
        int[] numeroJugador = administracion.getBoleto().getNumero();
        ordenarArray(numeroJugador);

        System.out.println("\n******************************************   ******************************************");
        System.out.printf("*%25s%16s%4s%28s%13s\n", "TU BOLETO", "*", "*", "BOLETO GANADOR", "*");
        System.out.printf("*%41s%4s%41s\n", "*", "*", "*");
        System.out.printf("*%10s", "Número: ");
        for (int i = 0; i < numeroJugador.length; i++) {
            if (i == (numeroJugador.length - 1)) {
                System.out.printf("%2d", numeroJugador[i]);
            } else {
                System.out.printf("%2d-", numeroJugador[i]);
            }
        }
        System.out.printf("%14s%4s%10s", "*", "*", "Número: ");
        for (int i = 0; i < numeroGanador.length; i++) {
            if (i == (numeroGanador.length - 1)) {
                System.out.printf("%2d", numeroGanador[i]);
            } else {
                System.out.printf("%2d-", numeroGanador[i]);
            }
        }
        System.out.printf("%14s\n", "*");

        System.out.printf("*%13s%2d%26s%4s%18s%3d%20s\n", "Reintegro: ", administracion.getBoleto().getReintegro(), "*",
                "*", "Complementario: ", administracion.getSorteo().getComplementarioGanador(), "*");
        System.out.printf("*%41s%4s%13s%2d%26s\n", "*", "*", "Reintegro: ",
                administracion.getSorteo().getReintegroGanador(), "*");
        System.out.printf("*%41s%4s%41s\n", "*", "*", "*");
        System.out.println("******************************************   ******************************************");

    }

    private static void ordenarArray(int lista[]) {
        // Este método devuelve el array que le pasan como parametro ordenado. Podria
        // haber utilizado Arrays.sort().

        for (int i = 0; i < (lista.length - 1); i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i] > lista[j]) {
                    int variableauxiliar = lista[i];
                    lista[i] = lista[j];
                    lista[j] = variableauxiliar;
                }
            }
        }
    }

    private static void verPremios() {
        // Este método corresponde con la opción 8. Este mustra por pantalla la media de
        // premios del año 2016.
        System.out.println("\nJugadas a 1 euro: ");
        System.out.println("Premio especial - 53.235.749,93 €");
        System.out.println("1r premio - 1.468.716,47 €");
        System.out.println("2º premio - 63.534.07 €");
        System.out.println("3r premio - 2.543,36 €");
        System.out.println("4º premio - 71,49 €");
        System.out.println("5º premio - 8 €");
        System.out.println("Reintegro - 1 €");
    }

    public static String convertirTiempo(long millis) {
        // Este método le pasan como parametro un tiempo en Milisegundos y devuelve este
        // tiempo en minutos y segundos.
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        millis -= TimeUnit.SECONDS.toMillis(seconds);

        StringBuilder sb = new StringBuilder(64);
        sb.append(minutes);
        sb.append(" Minutos, ");
        sb.append(seconds);
        sb.append(" Segundos y ");
        sb.append(millis);
        sb.append(" Milisegundos");

        return (sb.toString());
    }
}