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
    public void mIniciar() {
        boolean salir = false;
        while (!salir) {
            switch (vista.mMostrarMenuPrincipal()) {
                case 1 -> mGestionarArreglo1D();
                case 2 -> mGestionarArreglo2D();
                case 3 -> salir = true;
                default -> vista.mMostrarMensaje("Opción no válida.");
            }
        }
        vista.mCerrar();
    }

    /* ================== ARREGLO 1D ================== */

    /** Muestra submenú y opera sobre el modelo 1D. */
    private void mGestionarArreglo1D() {
        if (arreglo1D == null) {
            int longitud = vista.mLeerEntero("Longitud del arreglo 1D");
            arreglo1D = new ArregloUnidimensional(longitud);
        }
        boolean volver = false;
        while (!volver) {
            switch (vista.mMostrarMenuArreglo1D()) {
                case 1 -> {
                    arreglo1D.mCargarAleatorio();
                    vista.mMostrarMensaje("Arreglo cargado aleatoriamente.");
                }
                case 2 -> arreglo1D.mCargarManual(vista.mGetScanner());
                case 3 -> arreglo1D.mImprimir();
                case 4 -> vista.mMostrarMensaje("Suma = " + arreglo1D.mSumar());
                case 5 -> vista.mMostrarMensaje("Suma de pares = " + arreglo1D.mSumarPares());
                case 6 -> vista.mMostrarMensaje("Suma de impares = " + arreglo1D.mSumarImpares());
                case 7 -> vista.mMostrarMensaje("Menor = " + arreglo1D.mMenor());
                case 8 -> vista.mMostrarMensaje("Mayor = " + arreglo1D.mMayor());
                case 9 -> {
                    int indice = vista.mLeerEntero("Indice a modificar");
                    int valor = vista.mLeerEntero("Nuevo valor");
                    arreglo1D.mAsignar(indice, valor);
                }
                case 10 -> {
                    int longitud = vista.mLeerEntero("Longitud del nuevo arreglo");
                    int[] nuevo = ArregloUnidimensional.mCrearManual(longitud, vista.mGetScanner());
                    int suma = ArregloUnidimensional.mSumar(nuevo);
                    vista.mMostrarMensaje("Suma del arreglo ingresado = " + suma);
                }
                case 11 -> {
                    int longitud = vista.mLeerEntero("Longitud de los arreglos");
                    int[] primero = ArregloUnidimensional.mCrearManual(longitud, vista.mGetScanner());
                    int[] segundo = ArregloUnidimensional.mCrearManual(longitud, vista.mGetScanner());
                    int[] resultado = ArregloUnidimensional.mSumarElementoAPosicion(primero, segundo);
                    vista.mMostrarMensaje("Resultado de la suma posición a posicion:");
                    ArregloUnidimensional.mImprimir(resultado);
                }
                case 0 -> volver = true;
                default -> vista.mMostrarMensaje("Opcion no válida.");
            }
        }
    }

    /* ================== ARREGLO 2D ================== */

    /** Muestra submenú y opera sobre el modelo 2D. */
    private void mGestionarArreglo2D() {
        if (arreglo2D == null) {
            int filas = vista.mLeerEntero("Filas");
            int columnas = vista.mLeerEntero("Columnas");
            arreglo2D = new ArregloBidimensional(filas, columnas);
        }
        boolean volver = false;
        while (!volver) {
            switch (vista.mMostrarMenuArreglo2D()) {
                case 1 -> {
                    arreglo2D.mCargarAleatorio();
                    vista.mMostrarMensaje("Matriz cargada aleatoriamente.");
                }
                case 2 -> arreglo2D.mCargarManual(vista.mGetScanner());
                case 3 -> arreglo2D.mImprimir();
                case 4 -> vista.mMostrarMensaje("Suma = " + arreglo2D.mSumar());
                case 5 -> vista.mMostrarMensaje("Suma de pares = " + arreglo2D.mSumarPares());
                case 6 -> vista.mMostrarMensaje("Suma de impares = " + arreglo2D.mSumarImpares());
                case 7 -> vista.mMostrarMensaje("Menor = " + arreglo2D.mMenor());
                case 8 -> vista.mMostrarMensaje("Mayor = " + arreglo2D.mMayor());
                case 9 -> {
                    int fila = vista.mLeerEntero("Fila");
                    int columna = vista.mLeerEntero("Columna");
                    int valor = vista.mLeerEntero("Nuevo valor");
                    arreglo2D.mAsignar(fila, columna, valor);
                }
                case 10 -> {
                    int filas = vista.mLeerEntero("Filas de la matriz");
                    int columnas = vista.mLeerEntero("Columnas de la matriz");
                    int[][] nuevaMatriz = ArregloBidimensional.mCrearManual(filas, columnas, vista.mGetScanner());
                    int suma = ArregloBidimensional.mSumar(nuevaMatriz);
                    vista.mMostrarMensaje("Suma de la matriz ingresada = " + suma);
                }
                case 11 -> {
                    int filas = vista.mLeerEntero("Filas");
                    int columnas = vista.mLeerEntero("Columnas");
                    vista.mMostrarMensaje("Ingrese la primera matriz:");
                    int[][] primera = ArregloBidimensional.mCrearManual(filas, columnas, vista.mGetScanner());
                    vista.mMostrarMensaje("Ingrese la segunda matriz:");
                    int[][] segunda = ArregloBidimensional.mCrearManual(filas, columnas, vista.mGetScanner());
                    int[][] resultado = ArregloBidimensional.mSumarMatrices(primera, segunda);
                    vista.mMostrarMensaje("Resultado de la suma posición a posicion:");
                    ArregloBidimensional.mImprimir(resultado);
                }
                case 0 -> volver = true;
                default -> vista.mMostrarMensaje("Opcion no válida.");
            }
        }
    }
}
