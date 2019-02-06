package com.joanmanera.tema09.ejercicio09;

public class Ejercicio09 {
    public Ejercicio09(){
        int numero = 2;
        int[] array1 = new int[]{-2, -1, 0, 1, 2};
        int[] array2 = null;
        dividirEntreArray(numero, array1);
        dividirEntreArray(numero, array2);

    }
    private void dividirEntreArray(int numero, int[] array){
        for(int i = 0 ; i < 10 ; i++){
            try{
                throw new MyMistakes("ERROR");
            } catch (MyMistakes e) {
                System.out.println("Excepción: " + e.getMessage());
            }
        }
    }
}
