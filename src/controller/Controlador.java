package controller;

import model.ArregloUnidimensional;
import model.ArregloBidimensional;
import view.Vista;

/**
 * Coordina la interacción entre la {@link Vista} y los modelos de datos,
 * aplicando el patrón MVC.
 *
 * <p>Instancia y gestiona los menús de operaciones para los arreglos
 * unidimensionales y bidimensionales.</p>
 *
 * @author Equipo
 */
public class Controlador {

    /* ================== ATRIBUTOS ================== */

    /** Componente de entrada / salida. */
    private final Vista vista;

    /** Modelo para arreglo unidimensional. Se crea bajo demanda. */
    private ArregloUnidimensional arreglo1D;

    /** Modelo para matriz bidimensional. Se crea bajo demanda. */
    private ArregloBidimensional arreglo2D;

    /* ================== CONSTRUCTOR ================== */

    /**
     * Construye el controlador principal.
     *
     * @param vista instancia de {@link Vista} para la interacción con el usuario
     */
    public Controlador(Vista vista) {
        this.vista = vista;
    }

    /* ================== BUCLE PRINCIPAL ================== */

    /** Lanza el menú principal y distribuye las opciones. */
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            switch (vista.mostrarMenuPrincipal()) {
                case 1 -> gestionarArreglo1D();
                case 2 -> gestionarArreglo2D();
                case 3 -> salir = true;
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        }
        vista.cerrar();
    }

    /* ================== ARREGLO 1D ================== */

    /** Muestra submenú y opera sobre el modelo 1D. */
    private void gestionarArreglo1D() {
        if (arreglo1D == null) {
            int longitud = vista.leerEntero("Longitud del arreglo 1D");
            arreglo1D = new ArregloUnidimensional(longitud);
        }
        boolean volver = false;
        while (!volver) {
            switch (vista.mostrarMenuArreglo1D()) {
                case 1 -> {
                    arreglo1D.cargarAleatorio();
                    vista.mostrarMensaje("Arreglo cargado aleatoriamente.");
                }
                case 2 -> arreglo1D.cargarManual(vista.getScanner());
                case 3 -> arreglo1D.imprimir();
                case 4 -> vista.mostrarMensaje("Suma = " + arreglo1D.sumar());
                case 5 -> vista.mostrarMensaje("Suma de pares = " + arreglo1D.sumarPares());
                case 6 -> vista.mostrarMensaje("Suma de impares = " + arreglo1D.sumarImpares());
                case 7 -> vista.mostrarMensaje("Menor = " + arreglo1D.menor());
                case 8 -> vista.mostrarMensaje("Mayor = " + arreglo1D.mayor());
                case 9 -> {
                    int indice = vista.leerEntero("Indice a modificar");
                    int valor = vista.leerEntero("Nuevo valor");
                    arreglo1D.asignar(indice, valor);
                }
                case 10 -> {
                    int longitud = vista.leerEntero("Longitud del nuevo arreglo");
                    int[] nuevo = ArregloUnidimensional.crearManual(longitud, vista.getScanner());
                    int suma = ArregloUnidimensional.sumar(nuevo);
                    vista.mostrarMensaje("Suma del arreglo ingresado = " + suma);
                }
                case 11 -> {
                    int longitud = vista.leerEntero("Longitud de los arreglos");
                    int[] primero = ArregloUnidimensional.crearManual(longitud, vista.getScanner());
                    int[] segundo = ArregloUnidimensional.crearManual(longitud, vista.getScanner());
                    int[] resultado = ArregloUnidimensional.sumarElementoAPosicion(primero, segundo);
                    vista.mostrarMensaje("Resultado de la suma posición a posicion:");
                    ArregloUnidimensional.imprimir(resultado);
                }
                case 0 -> volver = true;
                default -> vista.mostrarMensaje("Opcion no válida.");
            }
        }
    }

    /* ================== ARREGLO 2D ================== */

    /** Muestra submenú y opera sobre el modelo 2D. */
    private void gestionarArreglo2D() {
        if (arreglo2D == null) {
            int filas = vista.leerEntero("Filas");
            int columnas = vista.leerEntero("Columnas");
            arreglo2D = new ArregloBidimensional(filas, columnas);
        }
        boolean volver = false;
        while (!volver) {
            switch (vista.mostrarMenuArreglo2D()) {
                case 1 -> {
                    arreglo2D.cargarAleatorio();
                    vista.mostrarMensaje("Matriz cargada aleatoriamente.");
                }
                case 2 -> arreglo2D.cargarManual(vista.getScanner());
                case 3 -> arreglo2D.imprimir();
                case 4 -> vista.mostrarMensaje("Suma = " + arreglo2D.sumar());
                case 5 -> vista.mostrarMensaje("Suma de pares = " + arreglo2D.sumarPares());
                case 6 -> vista.mostrarMensaje("Suma de impares = " + arreglo2D.sumarImpares());
                case 7 -> vista.mostrarMensaje("Menor = " + arreglo2D.menor());
                case 8 -> vista.mostrarMensaje("Mayor = " + arreglo2D.mayor());
                case 9 -> {
                    int fila = vista.leerEntero("Fila");
                    int columna = vista.leerEntero("Columna");
                    int valor = vista.leerEntero("Nuevo valor");
                    arreglo2D.asignar(fila, columna, valor);
                }
                case 10 -> {
                    int filas = vista.leerEntero("Filas de la matriz");
                    int columnas = vista.leerEntero("Columnas de la matriz");
                    int[][] nuevaMatriz = ArregloBidimensional.crearManual(filas, columnas, vista.getScanner());
                    int suma = ArregloBidimensional.sumar(nuevaMatriz);
                    vista.mostrarMensaje("Suma de la matriz ingresada = " + suma);
                }
                case 11 -> {
                    int filas = vista.leerEntero("Filas");
                    int columnas = vista.leerEntero("Columnas");
                    vista.mostrarMensaje("Ingrese la primera matriz:");
                    int[][] primera = ArregloBidimensional.crearManual(filas, columnas, vista.getScanner());
                    vista.mostrarMensaje("Ingrese la segunda matriz:");
                    int[][] segunda = ArregloBidimensional.crearManual(filas, columnas, vista.getScanner());
                    int[][] resultado = ArregloBidimensional.sumarMatrices(primera, segunda);
                    vista.mostrarMensaje("Resultado de la suma posición a posicion:");
                    ArregloBidimensional.imprimir(resultado);
                }
                case 0 -> volver = true;
                default -> vista.mostrarMensaje("Opcion no válida.");
            }
        }
    }
}
