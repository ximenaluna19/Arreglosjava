import java.util.Scanner;

// CLASE PADRE: Arreglo
class Arreglo {
    // Todas las partes de este código comparten un mismo teclado virtual. 
    protected static Scanner objSc = new Scanner(System.in);
} // Fin de la clase Arreglo


// CLASE HIJA: Vector (Hereda de Arreglo)
class Vector extends Arreglo {
    // Aquí se guardarán los 15 números enteros. 
    private int[] datos;

    // Primer punto: llenar el vector 
    public void llenarVector() {
        datos = new int[15];
        System.out.println("\n=== 1. LLENAR EL VECTOR ===");
        
        int i = 0; 
        while (i < 15) {
            System.out.print("Mete el valor para la posicion [" + i + "] (entre 10 y 100): ");
            int numeroIngresado = objSc.nextInt();
            
            if (numeroIngresado >= 10 && numeroIngresado <= 100) {
                datos[i] = numeroIngresado; 
                i = i + 1; 
            } else {
                System.out.println("-> Error: Ese numero no sirve. Vuelve a intentar.");
            }
        }

        System.out.print("Asi quedo el vector: [ ");
        for (int j = 0; j < 15; j++) {
            System.out.print(datos[j] + " "); 
        }
        System.out.println("]");
    }

    // Segundo punto: buscar un numero dentro del vector 
    public void buscarNumero(int numeroABuscar) {
        boolean loEncontro = false;
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
        int mayor = datos[0];
        int menor = datos[0];

        for (int i = 0; i < 15; i++) {
            if (datos[i] > mayor) mayor = datos[i];
            if (datos[i] < menor) menor = datos[i];
        }
        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);
    }

    // Cuarto punto: identificar múltiplos de un número
    public void mostrarMultiplos(int numeroX) {
        boolean hayMultiplos = false;
        System.out.print("Múltiplos de " + numeroX + " hallados en el vector: ");
        for (int i = 0; i < 15; i++) {
            if (numeroX != 0 && datos[i] % numeroX == 0) {
                System.out.print(datos[i] + " ");
                hayMultiplos = true;
            }
        }
        if (!hayMultiplos) System.out.print("No hay múltiplos de " + numeroX + " en el vector.");
        System.out.println(); 
    }

    // Quinto punto: Calcular la suma de todos los valores
    public int calcularSuma() {
        int suma = 0;
        for (int i = 0; i < 15; i++) suma += datos[i];
        System.out.println("-> La suma total de los elementos es: " + suma);
        return suma; 
    }

    // Sexto punto: Crear un vector con numeros por encima del promedio
    public void mayoresAlPromedio(int sumaTotal) {
        double promedio = sumaTotal / 15.0;
        System.out.println("-> El promedio del vector es: " + promedio);

        int cantidadMayores = 0;
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
    public static void main(String[] args) {
        Scanner objTeclado = Arreglo.objSc;
        Vector miTarea = new Vector();
        
        int opcionSeleccionada = 0;
        boolean vectorLleno = false;

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

            // Aquí se usa 'objTeclado', eliminando la advertencia
            opcionSeleccionada = objTeclado.nextInt();

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