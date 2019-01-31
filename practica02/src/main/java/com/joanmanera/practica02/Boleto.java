package com.joanmanera.practica02;

public class Boleto {
    private int[] numeroDelCliente; // En este array se guardá el numero del jugador
    private int reintegro;  // Aqui se guardara el reintegro del jugador

    private int contadorNumero; //Contador para saber la posicion de la siguiente posicion del array numerosQueHanSalido;
    private int[] numerosQueHanSalido = new int[7]; //Array donde se guardaran los numeros que han salido al generar un boleto.

    public Boleto(int[] numeroDelCliente) {
        /*
         *  Constructor de la clase Boleto que le pasan un array donde está la combinacion de numeros que
         *  ha introducido el jugador y un numero complementario que ha introducido el jugador. El numero
         *  del reintegro se genera aleatoriamente.
         */
        this.numeroDelCliente = numeroDelCliente;
        this.reintegro = Lib.randomAleatorio(10);
    }

    public Boleto() {
        /*
         *  Constructor de la clase Boleto que no le pasan ningún parámetro. Este llama el método generarBoleto() que genera
         *  el numero del jugador, llama a generarComplementario() que genera el numero complementário del jugador y
         *  genera aleatoriamente el numero del reintegro del jugador.
         */
        this.numeroDelCliente = generarBoleto();
        this.reintegro = Lib.randomAleatorio(10);
    }

    // Creo los getters para poder saber la combinacion del jugador
    public int[] getNumero() {
        return numeroDelCliente;
    }

    public int getReintegro() {
        return reintegro;
    }

    private int[] generarBoleto() {
        /*  Este metodo genera el numero de un boleto. Podria haber reutilizado el metodo getBolaBombo1(), que me devuelve
         *  de una bola pero sin repetir y esto dentro de un bucle que se ejecute hasta llenar el array de numeroDelCliente().
         *  Pero en realidad un boleto lo genera una maquina, no se crea un sorteo para determinar el numero.
         */
        int aux;
        numeroDelCliente = new int[6];
        for (int i = 0; i < numeroDelCliente.length; i++) {
            aux = Lib.randomAleatorio(1, 49);
            if (!haSalido(aux)) {
                numeroDelCliente[i] = aux;
                numerosQueHanSalido[contadorNumero] = aux;
                contadorNumero++;
            } else {
                i = i - 1;
            }
        }
        return numeroDelCliente;
    }


    private boolean haSalido(int aux) {
        /*  Este metodo lo utilizo para comprobar que el numero que le pasan como parametro (aux), no esta
         *  en el array de los numeros que han salido. Si el numero esta en el array devuelve true, de lo contrario
         *  devuelve false.
         */
        for (int i = 0; i < numerosQueHanSalido.length; i++) {
            if (aux == numerosQueHanSalido[i]) {
                return true;
            }
        }
        return false;
    }

}