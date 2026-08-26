// Importamos scanner que es una herramienta que nos permite leer lo que el usuario en su teclado
import java.util.Scanner;

// CLASE PADRE: Arreglo
class Arreglo {
    // Todas las partes de este código comparten un mismo teclado virtual.
    //cualquier clase hija puede usar este mismo teclado sin crear uno nuevo".
    protected static Scanner objSc = new Scanner(System.in);
} // Fin de la clase Arreglo


// CLASE HIJA: Vector (Hereda de Arreglo) 
// Es decir, puede usar el teclado (objSc) que creamos arriba.
class Vector extends Arreglo {
    // Aquí vamos a guardar los 15 números enteros
    private int[] datos;

    // Primer punto: llenar el vector 
    public void llenarVector() {
        // Aqui reservamos el espacio solo para 15 numeros
        datos = new int[15];
        System.out.println("\n=== 1. LLENAR EL VECTOR ===");
        
        // iniciamos un contador en 0
        int i = 0; 

        // Un ciclo while, que se va a reétir hasta que no hayamos llenado todos los espacios. 
        while (i < 15) {
            System.out.print("Mete el valor para la posicion [" + i + "] (entre 10 y 100): ");
            
            // Aqui guardamos el numero ingresado en "numeroIngresado"
            int numeroIngresado = objSc.nextInt();
            
            // Aqui verifica si el numero ingresado esta dentro del rango requerido
            if (numeroIngresado >= 10 && numeroIngresado <= 100) {
                datos[i] = numeroIngresado; 
                i = i + 1; 
            } else {
                // Si los numeros no estan en el rango, marcara error
                System.out.println("-> Error: Ese numero no sirve. Vuelve a intentar.");
            }
        }

        // Una vez llenados los 15 espacios se mostrara el vector en pantalla
        System.out.print("Asi quedo el vector: [ ");

        // Usamos un ciclo for para leer nuestros 15 datos 
        for (int j = 0; j < 15; j++) {
            System.out.print(datos[j] + " "); 
        }
        System.out.println("]");
    }

    // Segundo punto: buscar un numero dentro del vector 
    public void buscarNumero(int numeroABuscar) {
        // Nos avisara si lo encontramos o no
        boolean loEncontro = false;

        // Iniciamos un ciclo for para revisar desde la posicion 0 a la 14
        for (int i = 0; i < 15; i++) {
            if (datos[i] == numeroABuscar) {
                System.out.println("-> ¡Lo encontre! El numero " + numeroABuscar + " esta en la posicion: " + i);
                loEncontro = true;
            }
        }
        if (!loEncontro) {
            System.out.println("-> El numero " + numeroABuscar + " no esta en el vector.");
        }
    }

    // Tercer punto: Encontrar y mostrar el numero mayor y menor del vector
    public void mostrarMayorMenor() {
        // Iniciamos dos contadores, suponuendo que el primer va a ser mayor y menor a la vez
        int mayor = datos[0];
        int menor = datos[0];

        // Con este ciclo for recorremos todos los numeros y los comparamos
        for (int i = 0; i < 15; i++) {

            // Si encuentra un numero mayor que el mayor actual se reemplaza
            if (datos[i] > mayor) mayor = datos[i];
            // si encuentra un numero mas pequeño que el actual se reemplaza
            if (datos[i] < menor) menor = datos[i];
        }
        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);
    }

    // Cuarto punto: identificar múltiplos de un número
    public void mostrarMultiplos(int numeroX) {
        boolean hayMultiplos = false;
        System.out.print("Múltiplos de " + numeroX + " hallados en el vector: ");

        // Si divido mi dato entre 'numeroX' y el residuo es 0, ¡es un múltiplo!
       //tambien revisamos que numeroX no sea 0 para evitar que de error la division
        for (int i = 0; i < 15; i++) {
            if (numeroX != 0 && datos[i] % numeroX == 0) {
                System.out.print(datos[i] + " ");
                hayMultiplos = true;
            }
        }

        // Si no encuentra ningun multiplo nos va a imprimir este mensaje
        if (!hayMultiplos) System.out.print("No hay múltiplos de " + numeroX + " en el vector.");
        System.out.println(); 
    }

    // Quinto punto: Calcular la suma de todos los valores
    public int calcularSuma() {
        int suma = 0; //Aqui iremos gurdando las sumas 
        for (int i = 0; i < 15; i++) suma += datos[i];
        System.out.println("-> La suma total de los elementos es: " + suma);
        return suma; 
    }

    // Sexto punto: Crear un vector con numeros por encima del promedio
    public void mayoresAlPromedio(int sumaTotal) {
        // Sacamos el promedio: la suma dividida entre los 15 números.
        // Ponemos 15.0 para que el resultado tenga decimales (double).
        double promedio = sumaTotal / 15.0;
        System.out.println("-> El promedio del vector es: " + promedio);

        // Primero tenemos que contar cuántos números le ganan al promedio.
        int cantidadMayores = 0;
        for (int i = 0; i < 15; i++) {
            if (datos[i] > promedio) cantidadMayores++;
        }

        if (cantidadMayores == 0) {
            System.out.println("-> No hay numeros mayores al promedio.");
        } else {
            // Creamos un nuevo arreglo
            int[] nuevoVector = new int[cantidadMayores];
            int pos = 0;// Esta variable nos ayudará a saber en qué posición de la nueva cubeta vamos.

            // con este ciclo for volvemos a recorer el vector priginal
            for (int i = 0; i < 15; i++) {
                // Si le gana al promedio, lo guardamos en el nuevo arreglo
                if (datos[i] > promedio) {
                    nuevoVector[pos] = datos[i];
                    pos++;// Si le gana al promedio, lo guardamos en la nueva cubeta
                }
            }

            // Finalmente imprimimos 
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
    public static void main(String[] args) {
        // Le damos un nombre más corto a nuestro teclado ("objTeclado")
        Scanner objTeclado = Arreglo.objSc;
        // creamos un objeto llamado mi tarea
        // que tiene todos los métodos  que programamos arriba.
        Vector miTarea = new Vector();
        
        int opcionSeleccionada = 0;
        // Banderita de seguridad: Empieza falsa. Nos sirve para que el usuario 
        // no intente sumar o buscar sin antes haber llenado los números.
        boolean vectorLleno = false;


        // Un ciclo "do-while" Sirve para que el menú se muestre 
        // al menos una vez, y se siga repitiendo hasta que el usuario elija salir (7).

        // Procedemos a crear el menu

        do {
            System.out.println("\n========= MENÚ DE ACTIVIDAD ARREGLOS =========");
            System.out.println("1. Llenar Vector");
            System.out.println("2. Buscar un número");
            System.out.println("3. Mostrar Mayor y Menor");
            System.out.println("4. Identificar Múltiplos");
            System.out.println("5. Calcular Suma Total");
            System.out.println("6. Crear Vector (Mayores al promedio)");
            System.out.println("7. Salir");
            System.out.print("Elija su opción: ");

            // Aquí se lee la opcion que escribio el usuario
            opcionSeleccionada = objTeclado.nextInt();

            // Dependiendo del número que puso el usuario, lo manda por un camino u otro.
            switch (opcionSeleccionada) {
                case 1:
                    miTarea.llenarVector();
                    vectorLleno = true;
                    break;

                case 2:
                    if (vectorLleno) {
                        System.out.print("Número que desea buscar: ");
                        int b = objTeclado.nextInt();
                        miTarea.buscarNumero(b);
                    } else {
                        System.out.println("-> Primero debe llenar el vector (Opción 1).");
                    }
                    break;

                case 3:
                    if (vectorLleno) {
                        miTarea.mostrarMayorMenor();
                    } else {
                        System.out.println("-> Primero debe llenar el vector (Opción 1).");
                    }
                    break;

                case 4:
                    if (vectorLleno) {
                        System.out.print("Ingrese número X para múltiplos: ");
                        int x = objTeclado.nextInt();
                        miTarea.mostrarMultiplos(x);
                    } else {
                        System.out.println("-> Primero debe llenar el vector (Opción 1).");
                    }
                    break;

                case 5:
                    if (vectorLleno) {
                        miTarea.calcularSuma();
                    } else {
                        System.out.println("-> Primero debe llenar el vector (Opción 1).");
                    }
                    break;

                case 6:
                    if (vectorLleno) {
                        int suma = miTarea.calcularSuma();
                        miTarea.mayoresAlPromedio(suma);
                    } else {
                        System.out.println("-> Primero debe llenar el vector (Opción 1).");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del programa... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionSeleccionada != 7);
    }
}

// FINAL