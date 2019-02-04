package com.joanmanera.tema09.ejercicio08;

public class Ejercicio08 {
    public Ejercicio08(){
        int numero = 2;
        int[] array1 = new int[]{-2, -1, 0, 1, 2};
        int[] array2 = null;
        dividirEntreArray(numero, array1);
        dividirEntreArray(numero, array2);

    }
    private void dividirEntreArray(int numero, int[] array){
        for(int i = 0 ; i < 10 ; i++){
            try{
                System.out.println(numero/array[i]);
            } catch (NullPointerException npe){
                System.out.println("El valor de esta posición es null");
                return;
            } catch (ArithmeticException ae){
                System.out.println("Arithmetic Exception, posible division por 0");
            } catch (IndexOutOfBoundsException iobe){
                System.out.println("Ya has recorrido todo el array");
                return;
            }
        }
    }
}
