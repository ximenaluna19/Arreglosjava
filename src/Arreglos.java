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
// Segundo punto: buscar un numero dentro el vector 
// recibe el numero que se desea buscar y recorre los 15 elemeentos
    public void buscarNumero(int numeroABuscar) {
        boolean loEncontro = false;
        // El ciclo for lo utilizamos para que recorra el vector y verificar si el numero coincide
        for (int i = 0; i < 15; i++) {
            if (datos[i] == numeroABuscar) {
                System.out.println("-> ¡Lo encontre! El numero " + numeroABuscar + " esta en la posicion: " + i);
                loEncontro = true;
            }
        }
        if (loEncontro == false) {
            System.out.println("-> El numero " + numeroABuscar + " no esta en el vector.");
        }
    }

    // Tercer punto: Encontar y mostrar el numero mayor y menor del vector

    public void mostrarMayorMenor() {
        // Iniciamos con la primera posicion de Arreglos como punto inicial
        int mayor = datos[0];
        int menor = datos[0];

// Este ciclo for va a recorrer los 15 elementos del vector registrando si si el numero actual es MAYOR o MENOR que los ya registrados, de lo contrario los actualixa. 
        for (int i = 0; i < 15; i++) {
            if (datos[i] > mayor) mayor = datos[i];
            if (datos[i] < menor) menor = datos[i];
        }
        // Mostramos los resultados. 
        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);
    }

        
        // Cuarto punto: identificar multiplos de un numero, recorriendo el vector en busca de ellos.
    public void mostrarMultiplos(int numeroX) {
        // Indica si encontranos al menos un multiplo
        boolean hayMultiplos = false;
        System.out.print("Múltiplos de " + numeroX + " hallados en el vector: ");
        // este ciclo for recorre todo el vector y desimos que si el reciduo de la division es 0, es multiplo
        for (int i = 0; i < 15; i++) {
            if (numeroX != 0 && datos[i] % numeroX == 0) {
                System.out.print(datos[i] + " ");
                hayMultiplos = true;
            }
        }
        // Ponemos la condicion de que si no encuentra ningulo siga el false.
        if (!hayMultiplos) System.out.print("No hay múltiplos de " + numeroX + " en el vector.");
        System.out.println(); 
    }

    // Quinto punto: Calcular la suma de todos los valores
    public int calcularSuma() {
        // programamos un acumulador en 0
        int suma = 0;
        // el ciclo for recore el vector y suma cada numero 
        for (int i = 0; i < 15; i++) suma += datos[i];
        // Mostramos el resultado 
        System.out.println("-> La suma total de los elementos es: " + suma);
        return suma; 
    }

    // Sexto punto: Crear un vector con numeros por encima del promedio
    public void mayoresAlPromedio(int sumaTotal) {
        // Se procede a calcular el promedio en decimales. 
        double promedio = sumaTotal / 15.0;
        System.out.println("-> El promedio del vector es: " + promedio);

        // Creamos un contador para ver cuantos valores superan al promedio
        int cantidadMayores = 0;
        // El for recorre el vector comparando valores con el promedio
        for (int i = 0; i < 15; i++) {
            if (datos[i] > promedio) cantidadMayores++;
        }

        if (cantidadMayores == 0) {
            System.out.println("-> No hay numeros mayores al promedio.");
        } else {
            int[] nuevoVector = new int[cantidadMayores];
            int pos = 0;
            for (int i = 0; i < 15; i++) {
                if (datos[i] > promedio) {
                    nuevoVector[pos] = datos[i];
                    pos++;
                }
            }
            System.out.println("-> Se encontraron " + cantidadMayores + " numeros por encima del promedio.");
            System.out.print("Nuevo Vector: [ ");
            for (int i = 0; i < cantidadMayores; i++) {
                System.out.print(nuevoVector[i] + " ");
            }
            System.out.println("]");
        }
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



       

