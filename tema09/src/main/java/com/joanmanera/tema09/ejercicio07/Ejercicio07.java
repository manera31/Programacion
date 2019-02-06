package com.joanmanera.tema09.ejercicio07;

public class Ejercicio07 {
    public Ejercicio07(){
        String[] array = new String[]{"hola", null, "adios"};
        mostrarCadenasArray(array);
    }

    private void mostrarCadenasArray(String[] array){
        for(int i = 0 ; i < array.length ; i++){
            if (array[i] != null) {
                System.out.println(array[i].charAt(0));
            }
        }
    }
}
