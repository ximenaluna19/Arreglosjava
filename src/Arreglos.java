// CLASE PADRE: Arreglos

import java.util.Scanner;

class Arreglo {
    // Todas las partes de este codigo comparten un mismo teclado virtual. 
    protected static Scanner objSc = new Scanner(System.in);
} // Fin de la clase Arreglo


// CLASE HIJA: Vector (Hereda de Arreglo)
class Vector extends Arreglo {
    // Aqui se guardaran mis 15 numeros enteros. 
    private int[] datos;


    // Primer punto: llenar el vector 
    public void llenarVector() {
        // Le damos el tamaño requerido que en este caso es son 15 posiciones para numeros enteros
        datos = new int[15];
        System.out.println("1. LLENAR EL VECTOR");
        
        // Hacemos uso del ciclo while para ingresar y validar cada numero que el usuario ingrese.
        // Creamos un contador, para validar cuantos numeros validos van.  
        int i = 0; 
        // se repite hasta tener los 15 numeros validos. 
        while (i < 15) {
            System.out.print("Mete el valor para la posicion [" + i + "] (entre 10 y 100): ");
            int numeroIngresado = objSc.nextInt();
            
            // Aqui verificamos que el numero este en el rango de 10 - 100
            if (numeroIngresado >= 10 && numeroIngresado <= 100) {
                datos[i] = numeroIngresado; // lo guardo en el arreglo
                i = i + 1; // solo sumo 1 a la i si el numero esta bien
            } else {
                System.out.println("-> Error: Ese numero no sirve. Vuelve a intentar.");
            }
        }

    // Recorremos el arreglo con un ciclo for para mostrar los valores
        System.out.print("Asi quedo el vector: [ ");
        // El ciclo for recorre las posiciones desde la posicion 0 hasta la 14 (total de 15 elementos)
        for (int j = 0; j < 15; j++) {
            System.out.print(datos[j] + " "); // le pongo un espacio para que no se peguen
        }
        System.out.println("]");
    }
}

// CLASE PRINCIPAL: Arreglos
public class Arreglos {
    // Inicio del programa
    public static void main(String[] args) {
        // Creo el objeto de mi tarea
        Vector miTarea = new Vector();
        // Llamamos al metodo para llenar y mostrar el vector
        miTarea.llenarVector();
    }
}


       

