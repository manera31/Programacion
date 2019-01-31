package com.joanmanera.practica02;

public class Bombo {
    private int[] bombo1; // Aqui guardaré las bolas del bombo 1.
    private int[] bombo2; // Aqui guardaré las bolas del bombo 2.
    private int contadorBolas; // Para llevar un contador de las bolas que han salido.

    public Bombo() {
        this.bombo1 = new int[49]; // Array donde se van a guardar las bolas del bombo 1.
        resetearBombo1(); // Lleno el array del bombo 1 del 1 al 49.
        this.bombo2 = new int[] { 9, 4, 0, 5, 8, 6, 2, 3, 1, 7 }; // Inicializo las bolas del bombo 2 del 0 al 9.
        this.contadorBolas = 0; // Inicializo el contador a 0.
    }

    public void resetearBombo1() {
        /*
         * Este método vuelve a llenar el array de las bolas del bombo 1 ordenado.
         * Tambien resetea el contador a la longitud del array - 1.
         */
        for (int i = 0; i < bombo1.length; i++) {
            bombo1[i] = i + 1;
        }
        contadorBolas = (bombo1.length - 1);
    }

    public int getBolaBombo1() {
        /*
         * Este método genera un número aleatorio entre 0 y el contadorBolas. Guarda e
         * valor de la posición del array del número aleatorio. Pasa el último valor 
         * el array a la posición que acaba de salir. Le resta 1 al contadorBolas y
         * devuelve la bola que ha salido.
         */
        int bola, aux;
        while (true) {
            aux = Lib.randomAleatorio(0, contadorBolas);
            bola = bombo1[aux];
            bombo1[aux] = bombo1[contadorBolas];
            contadorBolas--;
            return bola;
        }
    }

    public int getBolaBombo2() {
        /*
         * Devuelve el valor de la posición del array del bombo 2 sobre un número
         * aleatorio entre el 0 y el 9. Prodria devolver directamente el número
         * aleatorio (entre 0 y 9), pero me parece que es mas real asi. Aqui no hago
         * ninguna comprobación ya que solo va ha salir un número.
         */
        return bombo2[Lib.randomAleatorio(10)];
    }

}