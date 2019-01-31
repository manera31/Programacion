package com.joanmanera.practica02;

public class Sorteo {
    private int[] combinacionGanadora; // Aqui guardaré la combinación ganadora al hacer el sorteo.
    private int complementario; // Aqui guardaré el número complementario.
    private int reintegro; // Aqui guardaré el número reintegro
    private Bombo bombo; // Creo un objeto de la classe bombo para poder sacar la combinación ganadora.

    public Sorteo() {
        this.combinacionGanadora = new int[6]; // Lo inizializo a 6 ya que se van a sacar 6 bolas que determinaran el
                                               // número ganador.
        this.complementario = 0;
        this.reintegro = 0;
        this.bombo = new Bombo();
    }

    /*
     * Estos getters los utilizo para poder ver la combinación ganadora desde la
     * clase Principal. No creo los setters porque no los considero necesarios, ya
     * que para hacer el sorteo tengo el método hacerSorteo(), que ya asigna la
     * combinación, el complementario y el reintegro ganador.
     */
    public int[] getNumeroGanador() {
        return combinacionGanadora;
    }

    public int getComplementarioGanador() {
        return complementario;
    }

    public int getReintegroGanador() {
        return reintegro;
    }

    /*
     * Este método resetea el bombo para que las bolas que han salido en el sorteo
     * anterior puedan volver a salir, llena el array de la combinacion ganadora,
     * despues saca el número complenentario (estos dos del bombo 1) y finalmente
     * saca el reintegro ganador (este del bombo 2)
     */
    public void hacerSorteo() {
        bombo.resetearBombo1();
        for (int i = 0; i < combinacionGanadora.length; i++) {
            combinacionGanadora[i] = bombo.getBolaBombo1();
        }
        complementario = bombo.getBolaBombo1();
        reintegro = bombo.getBolaBombo2();
    }
}