package com.joanmanera.practica02;

public class Administracion {
    private Sorteo sorteo; // Llamo a esta clase para que la administración pueda hacer un sorteo.
    private Boleto boleto; // En esta clase guardare el boleto del jugador.
    private int[] numerosAcertados; // Aqui guardaré los números que el jugador acierte para posteriormente
                                    // mostrarlos por pantalla cuando toque un premio.
    private boolean complementarioAcertado; // Esta variable la utilizaré para saber si el jugador ha acertado el
                                            // complementario. True si lo ha acertado o false si no lo ha hecho.
    private boolean reintegroAcertado; // Lo mismo que en la variable anterior pero esta combrobará el reintegro.
    private int aciertos; // En esta variable se guardará el número de aciertos al comparar el boleto
                          // ganador y el del jugador

    public Administracion() {
        /*
         * Este constructor crea un nuevo sorteo y un nuevo boleto. También inicializa
         * el array de los números acertados, al bolean de complementario y de reintegro
         * y el entero del codigo de acierto.
         */
        this.sorteo = new Sorteo();
        this.boleto = new Boleto();
        this.numerosAcertados = new int[6];
        this.complementarioAcertado = false;
        this.reintegroAcertado = false;
        this.aciertos = 0;
    }

    public void comprarBoleto(int[] numeroDelClente) {
        // Este método crea un nuevo objeto de la clase boleto con el número que le
        // pasan como parámetro.
        boleto = new Boleto(numeroDelClente);
    }

    public void comprarBoleto() {
        // Este método crea un nuevo objeto de la clase boleto pero con la combinación
        // aleatoria.
        boleto = new Boleto();
    }

    public void generarSorteo() {
        // Este método llama a la función de hacerSorteo() de la clase sorteo que
        // reinicia el bombo y vuelve a generar un sorteo.
        sorteo.hacerSorteo();
    }

    public Boleto getBoleto() {
        // Este método devuelve el objeto boleto para que desde la clase Principal se
        // pueda ver el boleto del jugador (su numero y su reintegro).
        return boleto;
    }

    public Sorteo getSorteo() {
        // Este método devuelve el objeto de la clase sorteo para poder ver desde la
        // clase Principal la combinación ganadora.
        return sorteo;
    }

    public int comprobarBoleto() {
        /*
         * Este método comprueba si el boleto del jugador es premiado o no. Primero
         * comprueba si el reintegro lo ha acertado, luego si ha acertado el
         * complementario y finalmente comprueba el número. El bucle recorre el array de
         * la combinación ganadora y el del jugador. Si un número se repite en los dos
         * arrays, este se guarda en un tercero (numerosAcertados) y el contador de
         * codigoAciertos se incrementa. Si no se repite el número pasa al siguiente.
         *
         * Devuelve dependiendo de la cantidad de aciertos, un código de aciertos. Este
         * luego servira para saber que premio le ha tocado al jugador. Este código no
         * sigue ningún orden.
         */

        reintegroAcertado = boleto.getReintegro() == sorteo.getReintegroGanador();

        complementarioAcertado = false;

        aciertos = 0;

        for (int i = 0; i < sorteo.getNumeroGanador().length; i++) {
            for (int x = 0; x < boleto.getNumero().length; x++) {
                if (sorteo.getNumeroGanador()[i] == boleto.getNumero()[x]) {
                    numerosAcertados[aciertos] = sorteo.getNumeroGanador()[i];
                    aciertos++;
                } else if (boleto.getNumero()[x] == sorteo.getComplementarioGanador()) {
                    complementarioAcertado = true;
                }
            }
        }

        if (aciertos == 3) {
            return 1;

        } else if (aciertos == 4) {
            return 2;

        } else if (aciertos == 5 && complementarioAcertado) {
            return 4;

        } else if (aciertos == 5) {
            return 3;

        } else if (aciertos == 6 && reintegroAcertado) {
            return 6;

        } else if (aciertos == 6) {
            return 5;

        } else if (reintegroAcertado) {
            return 7;

        } else {
            return 0;
        }
    }

    public void mostrarPremio(int codigoAciertos) {
        /*
         * A este método le pasan como parámetro el código de aciertos que le devuelve
         * el método comprobarBoleto() y muestra un mensaje según el número de aciertos.
         */
        System.out.println();
        switch (codigoAciertos) {
        case 0:
            System.out.println("Tu boleto no ha sido premiado");
            break;
        case 1:
            System.out.println("Felicidades, has ganado el 5º premio!!");
            System.out.print("Los numeros que has acertado son: ");
            for (int i = 0; i < aciertos; i++) {
                System.out.print(numerosAcertados[i] + " ");
            }

            break;
        case 2:
            System.out.println("Felicidades, has ganado el 4º premio!!");
            System.out.print("Los numeros que has acertado son: ");
            for (int i = 0; i < aciertos; i++) {
                System.out.print(numerosAcertados[i] + " ");
            }

            break;
        case 3:
            System.out.println("Felicidades, has ganado el 3r premio!!");
            System.out.print("Los numeros que has acertado son: ");
            for (int i = 0; i < aciertos; i++) {
                System.out.print(numerosAcertados[i] + " ");
            }

            break;
        case 4:
            System.out.println("Felicidades, has ganado el 2º premio!!");
            System.out.print("Los numeros que has acertado son: ");
            for (int i = 0; i < aciertos; i++) {
                System.out.print(numerosAcertados[i] + " ");
            }
            System.out.println();
            System.out.println("Y el numero complementario acertado es: " + sorteo.getComplementarioGanador());

            break;
        case 5:
            System.out.println("Felicidades, has ganado el 1r premio!!");

            break;
        case 6:
            System.out.println("Felicidades, has ganado el premio ESPECIAL !!");

            break;
        case 7:

            System.out.println("Felicidades, has acertado el reintegro: " + boleto.getReintegro());
            break;

        default:
            System.out.println("ERROR al leer los premios");
            break;
        }
        System.out.println();

    }
}