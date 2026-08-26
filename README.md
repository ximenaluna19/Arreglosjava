# EA1 - Vectores (Arreglos en Java)

Programa en Java para gestionar un vector de 15 números enteros mediante un menú interactivo. El programa permite llenar, buscar, analizar y manipular los datos del vector con validación de rango (valores entre 10 y 100).


# 1.¿Qué hace este programa?

Es un programa en Java que maneja un **vector** (que es como una fila de casillas) con **15 espacios** para guardar números enteros. El usuario puede elegir qué quiere hacer con esos números desde un **menú interactivo** que se repite hasta que él decida salir.

# 2. ¿Cómo está organizado el código?

El programa tiene **3 clases** (que son como "cajitas" que tienen cosas dentro):

- **`Arreglo`** (clase padre): Es la más sencilla. Solo tiene un Scanner que es la herramienta que sirve para leer lo que el usuario escribe en el teclado. La creamos aquí para que todas las demás clases la compartan, en lugar de crear una nueva en cada una.

- **`Vector`** (clase hija): Es donde está todo el trabajo pesado. Tiene 6 métodos (funciones) que hacen cada una de las operaciones. Hereda de `Arreglo`, lo que significa que puede usar el teclado que creamos arriba sin crear otro.

- **`Arreglos`** (clase principal): Contiene el `main`, que es por donde arranca el programa. Aquí se muestra el menú y se conecta todo.


# 3. ¿Qué hace cada opción del menú?

**Opción 1 — Llenar Vector:**
Reserva un espacio para 15 números (`new int[15]`). Usa un ciclo `while` que no se detiene hasta que las 15 casillas estén llenas. Si el usuario pone un número menor a 10 o mayor a 100, el programa lo rechaza y le pide que lo intente de nuevo. Al final, imprime todo el vector en pantalla.

**Opción 2 — Buscar un número:**
El usuario dice qué número quiere buscar. El programa recorre las 15 posiciones con un ciclo `for` y va comparando: si encuentra el número, dice en qué posición está. Si termina de recorrer y no lo encuentra, avisa que no está.

**Opción 3 — Mostrar Mayor y Menor:**
Primero asume que el primer número (`datos[0]`) es tanto el mayor como el menor. Luego recorre todo el vector comparando: si encuentra uno más grande, lo reemplaza como "mayor"; si encuentra uno más chico, lo reemplaza como "menor". Al final imprime ambos.

**Opción 4 — Identificar Múltiplos:**
El usuario ingresa un número X. El programa revisa cada posición del vector: si al dividir el número del vector entre X el residuo da 0 (usamos el operador `%`), significa que es múltiplo y lo imprime. También verifica que X no sea 0 para evitar un error de división.

**Opción 5 — Calcular Suma Total:**
Crea una variable `suma` en 0. Recorre las 15 posiciones y va sumando cada número a esa variable. Al final imprime el resultado y lo devuelve (`return`) porque la opción 6 lo necesita.

**Opción 6 — Crear Vector (Mayores al promedio):**
Primero saca el promedio: la suma total dividida entre 15 (usamos `15.0` para que el resultado tenga decimales). Luego cuenta cuántos números son mayores al promedio. Si hay algunos, crea un **nuevo vector** del tamaño exacto de esos números, los copia y lo imprime.

---

# 4. ¿Cómo funciona el menú?

Se usa un ciclo `do-while`: el menú se muestra **al menos una vez** y se repite mientras el usuario no elija la opción 7 (Salir). Dentro hay un `switch` que evalúa qué número eligió el usuario y ejecuta el método correspondiente.

Hay una **variable de seguridad** llamada `vectorLleno` que empieza en `false`. Si el usuario intenta buscar, sumar o hacer cualquier operación sin haber llenado primero el vector (opción 1), el programa le avisa que primero debe llenarlo.



# Video de Sustentación

> Agrega aquí el enlace a tu video de sustentación.

[Video de Sustentación](URL_DEL_VIDEO)


# Imagenes

![Captura 1](<Captura%20de%20pantalla%202026-08-25%20105419-1.png>)
![Captura 2](<Captura%20de%20pantalla%202026-08-25%20105618.png>)
![Captura 3](<Captura%20de%20pantalla%202026-08-25%20105636.png>)
![Captura 4](<Captura%20de%20pantalla%202026-08-25%20105704.png>)
![Captura 5](<Captura%20de%20pantalla%202026-08-25%20105739.png>)
