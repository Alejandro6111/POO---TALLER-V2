package model;

import java.util.Random;
import java.util.Scanner;

/**
 * Representa y administra una matriz de enteros (arreglo bidimensional)
 * con operaciones equivalentes a las del arreglo 1D.
 *
 * @author Equipo
 */
public class ArregloBidimensional {

    /** Datos almacenados. */
    private int[][] datos;

    /** Generador de numeros aleatorios. */
    private final Random randomGenerator = new Random();

    /**
     * Crea una matriz con las dimensiones indicadas.
     *
     * @param filas     numero de filas (&gt; 0)
     * @param columnas  numero de columnas (&gt; 0)
     * @throws IllegalArgumentException si alguna dimension no es valida
     */
    public ArregloBidimensional(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Dimensiones invalidas.");
        }
        datos = new int[filas][columnas];
    }

    /* ======= METODOS DE CARGA ======= */

    /** Llena la matriz con valores aleatorios. */
    public void mCargarAleatorio() {
        for (int fila = 0; fila < datos.length; fila++) {
            for (int columna = 0; columna < datos[fila].length; columna++) {
                datos[fila][columna] = randomGenerator.nextInt(100);
            }
        }
    }

    /**
     * Genera una matriz aleatoria estatica.
     *
     * @param filas    numero de filas
     * @param columnas numero de columnas
     * @return matriz poblada
     */
    public static int[][] mGenerarAleatorio(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        Random generador = new Random();
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                matriz[fila][columna] = generador.nextInt(100);
            }
        }
        return matriz;
    }

    /**
     * Carga la matriz interna desde la consola.
     *
     * @param lector scanner compartido
     */
    public void mCargarManual(Scanner lector) {
        for (int fila = 0; fila < datos.length; fila++) {
            for (int columna = 0; columna < datos[fila].length; columna++) {
                System.out.printf("Valor [%d][%d]: ", fila, columna);
                datos[fila][columna] = lector.nextInt();
            }
        }
    }

    /**
     * Crea una matriz ingresada por el usuario.
     *
     * @param filas    numero de filas
     * @param columnas numero de columnas
     * @param lector   scanner
     * @return matriz recien creada
     */
    public static int[][] mCrearManual(int filas, int columnas, Scanner lector) {
        int[][] matriz = new int[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                System.out.printf("Valor [%d][%d]: ", fila, columna);
                matriz[fila][columna] = lector.nextInt();
            }
        }
        return matriz;
    }

    /**
     * Carga datos en una matriz ya existente (parametro).
     *
     * @param destino matriz destino
     * @param lector  scanner
     * @return referencia a la misma matriz modificada
     */
    public static int[][] mCargarEn(int[][] destino, Scanner lector) {
        for (int fila = 0; fila < destino.length; fila++) {
            for (int columna = 0; columna < destino[fila].length; columna++) {
                System.out.printf("Valor [%d][%d]: ", fila, columna);
                destino[fila][columna] = lector.nextInt();
            }
        }
        return destino;
    }

    /* ======= OPERACIONES BASICAS ======= */

    /**
     * Asigna un valor a la posicion indicada.
     *
     * @param fila     indice de fila
     * @param columna  indice de columna
     * @param valor    valor a insertar
     */
    public void mAsignar(int fila, int columna, int valor) {
        if (fila < 0 || fila >= datos.length) return;
        if (columna < 0 || columna >= datos[0].length) return;
        datos[fila][columna] = valor;
    }

    /** Imprime la matriz interna en formato cuadricula. */
    public void mImprimir() {
        mImprimir(datos);
    }

    /**
     * Imprime una matriz proporcionada.
     *
     * @param matriz matriz a imprimir
     */
    public static void mImprimir(int[][] matriz) {
        for (int[] fila : matriz) {
            System.out.print("| ");
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println("|");
        }
    }

    /**
     * Calcula la suma de todos los elementos de la matriz interna.
     *
     * @return suma total
     */
    public int mSumar() {
        return mSumar(datos);
    }

    /**
     * Calcula la suma de los elementos de una matriz pasada por parametro.
     *
     * @param matriz matriz a sumar
     * @return suma total
     */
    public static int mSumar(int[][] matriz) {
        int total = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                total += valor;
            }
        }
        return total;
    }

    /**
     * Suma posicion a posicion dos matrices iguales o compatibles.
     *
     * @param primera primera matriz
     * @param segunda segunda matriz
     * @return nueva matriz con las sumas
     */
    public static int[][] mSumarMatrices(int[][] primera, int[][] segunda) {
        int filasComunes = Math.min(primera.length, segunda.length);
        int columnasComunes = Math.min(primera[0].length, segunda[0].length);
        int[][] resultado = new int[filasComunes][columnasComunes];

        for (int fila = 0; fila < filasComunes; fila++) {
            for (int columna = 0; columna < columnasComunes; columna++) {
                resultado[fila][columna] = primera[fila][columna] + segunda[fila][columna];
            }
        }
        return resultado;
    }

    /**
     * Suma de los numeros pares de la matriz interna.
     *
     * @return suma de pares
     */
    public int mSumarPares() {
        int sumaPares = 0;
        for (int[] fila : datos) {
            for (int valor : fila) {
                if (valor % 2 == 0) {
                    sumaPares += valor;
                }
            }
        }
        return sumaPares;
    }

    /**
     * Suma de los numeros impares de la matriz interna.
     *
     * @return suma de impares
     */
    public int mSumarImpares() {
        int sumaImpares = 0;
        for (int[] fila : datos) {
            for (int valor : fila) {
                if (valor % 2 != 0) {
                    sumaImpares += valor;
                }
            }
        }
        return sumaImpares;
    }

    /**
     * Obtiene el menor valor de la matriz interna.
     *
     * @return valor minimo
     */
    public int mMenor() {
        int minimo = datos[0][0];
        for (int[] fila : datos) {
            for (int valor : fila) {
                if (valor < minimo) {
                    minimo = valor;
                }
            }
        }
        return minimo;
    }

    /**
     * Obtiene el mayor valor de la matriz interna.
     *
     * @return valor maximo
     */
    public int mMayor() {
        int maximo = datos[0][0];
        for (int[] fila : datos) {
            for (int valor : fila) {
                if (valor > maximo) {
                    maximo = valor;
                }
            }
        }
        return maximo;
    }

    /**
     * Retorna la referencia a la matriz interna.
     *
     * @return matriz interna
     */
    public int[][] mGetDatos() {
        return datos;
    }
}
