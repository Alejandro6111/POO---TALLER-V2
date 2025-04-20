package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Gestiona toda la interaccion con el usuario por consola
 * (entradas y salidas de datos).
 *
 * <p>No contiene logica de negocio; solo E/S.</p>
 *
 * @author Equipo
 */
public class Vista {

    /** Lector de consola compartido con otros componentes. */
    private final Scanner lector = new Scanner(System.in);

    /* ---------- Menus principales ---------- */

    /**
     * Muestra el menu raiz de la aplicacion.
     *
     * @return numero de opcion elegida por el usuario
     */
    public int mMostrarMenuPrincipal() {
        System.out.println("\n─── MENU PRINCIPAL ───");
        System.out.println("1. Arreglo unidimensional");
        System.out.println("2. Arreglo bidimensional");
        System.out.println("3. Salir");
        return mLeerEntero("Seleccione una opcion");
    }

    /**
     * Muestra el menu de operaciones sobre un arreglo 1D.
     *
     * @return opcion elegida
     */
    public int mMostrarMenuArreglo1D() {
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
        System.out.println("11. Sumar posicion a posicion dos arreglos");
        System.out.println(" 0. Volver");
        return mLeerEntero("Seleccione una opcion");
    }

    /**
     * Muestra el menu de operaciones sobre una matriz 2D.
     *
     * @return opcion elegida
     */
    public int mMostrarMenuArreglo2D() {
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
        System.out.println("11. Sumar posicion a posicion dos matrices");
        System.out.println(" 0. Volver");
        return mLeerEntero("Seleccione una opcion");
    }

    /* ---------- Utilidades ---------- */

    /**
     * Lee un numero entero desde la consola con control de errores.
     *
     * @param mensaje texto que se muestra antes de la lectura
     * @return entero introducido por el usuario
     */
    public int mLeerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return lector.nextInt();
            } catch (InputMismatchException ex) {
                lector.nextLine(); // descarta entrada invalida
                System.out.println("Entrada invalida. Intente de nuevo.");
            }
        }
    }

    /**
     * Imprime un mensaje en consola.
     *
     * @param texto mensaje a mostrar
     */
    public void mMostrarMensaje(String texto) {
        System.out.println(texto);
    }

    /** Cierra el {@link Scanner} asociado a la consola. */
    public void mCerrar() {
        lector.close();
    }

    /**
     * Devuelve el {@link Scanner} interno para que otros modulos
     * puedan reutilizarlo y evitar multiples instancias.
     *
     * @return scanner compartido
     */
    public Scanner mGetScanner() {
        return lector;
    }
}
