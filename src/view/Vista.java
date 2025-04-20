package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Gestiona toda la interacción con el usuario por consola
 * (entradas y salidas de datos).
 *
 * <p>No contiene lógica de negocio; solo E/S.</p>
 *
 * @author Equipo
 */
public class Vista {

    /** Lector de consola compartido con otros componentes. */
    private final Scanner lector = new Scanner(System.in);

    /* ---------- Menús principales ---------- */

    /**
     * Muestra el menú raíz de la aplicación.
     *
     * @return número de opción elegida por el usuario
     */
    public int mostrarMenuPrincipal() {
        System.out.println("\n─── MENU PRINCIPAL ───");
        System.out.println("1. Arreglo unidimensional");
        System.out.println("2. Arreglo bidimensional");
        System.out.println("3. Salir");
        return leerEntero("Seleccione una opción");
    }

    /**
     * Muestra el menú de operaciones sobre un arreglo 1D.
     *
     * @return opción elegida
     */
    public int mostrarMenuArreglo1D() {
        System.out.println("\n── Arreglo Unidimensional ──");
        System.out.println(" 1. Crear aleatorio");
        System.out.println(" 2. Crear manual");
        System.out.println(" 3. Imprimir");
        System.out.println(" 4. Sumar todos los elementos");
        System.out.println(" 5. Sumar pares");
        System.out.println(" 6. Sumar impares");
        System.out.println(" 7. Obtener menor");
        System.out.println(" 8. Obtener mayor");
        System.out.println(" 9. Asignar valor");
        System.out.println("10. Sumar un arreglo ingresado");
        System.out.println("11. Sumar posicion a posición dos arreglos");
        System.out.println(" 0. Volver");
        return leerEntero("Seleccione una opción");
    }

    /**
     * Muestra el menú de operaciones sobre una matriz 2D.
     *
     * @return opción elegida
     */
    public int mostrarMenuArreglo2D() {
        System.out.println("\n── Arreglo Bidimensional ──");
        System.out.println(" 1. Crear aleatorio");
        System.out.println(" 2. Crear manual");
        System.out.println(" 3. Imprimir");
        System.out.println(" 4. Sumar todos los elementos");
        System.out.println(" 5. Sumar pares");
        System.out.println(" 6. Sumar impares");
        System.out.println(" 7. Obtener menor");
        System.out.println(" 8. Obtener mayor");
        System.out.println(" 9. Asignar valor");
        System.out.println("10. Sumar una matriz ingresada");
        System.out.println("11. Sumar posicion a posición dos matrices");
        System.out.println(" 0. Volver");
        return leerEntero("Seleccione una opcion");
    }

    /* ---------- Utilidades ---------- */

    /**
     * Lee un número entero desde la consola con control de errores.
     *
     * @param mensaje texto que se muestra antes de la lectura
     * @return entero introducido por el usuario
     */
    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return lector.nextInt();
            } catch (InputMismatchException ex) {
                lector.nextLine(); // descarta entrada inválida
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

    /**
     * Imprime un mensaje en consola.
     *
     * @param texto mensaje a mostrar
     */
    public void mostrarMensaje(String texto) {
        System.out.println(texto);
    }

    /** Cierra el {@link Scanner} asociado a la consola. */
    public void cerrar() {
        lector.close();
    }

    /**
     * Devuelve el {@link Scanner} interno para que otros módulos
     * puedan reutilizarlo y evitar múltiples instancias.
     *
     * @return scanner compartido
     */
    public Scanner getScanner() {
        return lector;
    }
}
