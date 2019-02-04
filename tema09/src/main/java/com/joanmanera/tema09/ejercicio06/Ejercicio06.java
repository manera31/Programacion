package com.joanmanera.tema09.ejercicio06;

public class Ejercicio06 {
    public Ejercicio06(){
        int numero = 2;
        int[] array = new int[]{-2, -1, 0, 1, 2};
        System.out.println("Método sin comprobación");
        dividirEntreArray1(numero, array);
        System.out.println("\nMétodo con comprobación");
        dividirEntreArray2(numero, array);
    }

    private void dividirEntreArray1(int numero, int[] array){
        for(int i = 0 ; i < array.length ; i++){
            try{
                System.out.println(numero/array[i]);
            } catch (ArithmeticException ae){
                System.out.println("Imposible hacer una división por 0");
            }
        }
    }
    private void dividirEntreArray2(int numero, int[] array){
        for(int i = 0 ; i < array.length ; i++){
            try{
                if(array[i] == 0){
                    System.out.println("Imposible hacer una división por 0");
                } else {
                    System.out.println(numero/array[i]);
                }

            } catch (ArithmeticException ae){
                System.out.println("Imposible hacer una división por 0");
            }
        }
    }
}
