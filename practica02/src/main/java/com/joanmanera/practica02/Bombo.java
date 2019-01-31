package com.joanmanera.practica02;

public class Bombo {
    private final int[] bombo1; // Para saber las bolas que tiene el bombo 1 (del 1 al 49)
    private final int[] bombo2; // Para saber las bolas que tiene el bombo 2 (del 0 al 9)
    private int contadorBolas; // Para llevar un contador de las bolas que han salido

    public Bombo() {
        this.bombo1 = new int[49];
        resetearBombo1();
        this.bombo2 = new int[] { 9, 4, 0, 5, 8, 6, 2, 3 ,1 , 7}; // Inicializo las bolas del bombo 2 del 0 al 9
        this.contadorBolas = 0;
    }

    public void resetearBombo1(){
        /*
         *  Este método vuelve a iniciar al array bolasQueHanSalido y el contador de este a 0 para que se pueda volver a hacer el sorteo
         *  sin tener que volver a crear un nuevo objeto de la clase Bombo.
         */
        for(int i = 0 ; i < bombo1.length ; i++){
            bombo1[i]=i+1;
        }
        contadorBolas = (bombo1.length-1);
    }
    public int getBolaBombo1() {
        /*
         *  Este método genera un numero aleatorio entre 0 y 48 ( 49 numeros ). Este aleatorio se utiliza para saber el valor del array que esa posición ( posición = aleatorio ).
         *  Llama al metodo haSalido() para saber si esta en el array de bolasQueHanSalido o no. Si ha salido, se repite hasta que salga un numero que no haya salido. Si no ha salido
         *  guarda este en el array de bolasQueHanSalido, incrementa su contador y devuelve la bola.
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
         * Devuelve el valor de la posicion del array del bombo 2 sobre un numero
         * aleatorio entre el 0 y el 9. Prodria devolver directamente el numero
         * aleatorio (entre 0 y 9), pero me parece que es mas real asi. Aqui no hago
         * ninguna comprobación ya que solo va ha salir un numero.
         */
        return bombo2[Lib.randomAleatorio(10)];
    }

}