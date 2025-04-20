package model;

import java.util.Random;
import java.util.Scanner;

/**
 * Representa y administra un arreglo unidimensional de enteros
 * cumpliendo todos los requisitos del taller.
 *
 * @author Equipo
 */
public class ArregloUnidimensional {

    /** Datos almacenados. */
    private int[] datos;

    /** Generador de numeros aleatorios. */
    private final Random randomGenerator = new Random();

    /**
     * Crea un arreglo con la longitud indicada.
     *
     * @param longitud tamaño del arreglo (debe ser &gt; 0)
     * @throws IllegalArgumentException si la longitud no es valida
     */
    public ArregloUnidimensional(int longitud) {
        if (longitud <= 0) {
            throw new IllegalArgumentException("La longitud debe ser positiva.");
        }
        datos = new int[longitud];
    }

    /* ======= METODOS DE CARGA ======= */

    /** Metodo 1: llena el arreglo interno con valores aleatorios. */
    public void mCargarAleatorio() {
        for (int indice = 0; indice < datos.length; indice++) {
            datos[indice] = randomGenerator.nextInt(100); // 0–99
        }
    }

    /**
     * Metodo 2: genera un nuevo arreglo aleatorio.
     *
     * @param longitud tamaño del arreglo
     * @return arreglo poblado con numeros aleatorios
     */
    public static int[] mGenerarAleatorio(int longitud) {
        int[] nuevoArreglo = new int[longitud];
        Random generador = new Random();
        for (int indice = 0; indice < longitud; indice++) {
            nuevoArreglo[indice] = generador.nextInt(100);
        }
        return nuevoArreglo;
    }

    /**
     * Metodo 3: carga el arreglo interno desde la entrada estandar.
     *
     * @param lector {@link Scanner} para lectura de datos
     */
    public void mCargarManual(Scanner lector) {
        for (int indice = 0; indice < datos.length; indice++) {
            System.out.print("Valor [" + indice + "]: ");
            datos[indice] = lector.nextInt();
        }
    }

    /**
     * Metodo 4: crea y devuelve un arreglo ingresado por el usuario.
     *
     * @param longitud tamaño
     * @param lector   scanner compartido
     * @return arreglo con los valores introducidos
     */
    public static int[] mCrearManual(int longitud, Scanner lector) {
        int[] nuevoArreglo = new int[longitud];
        for (int indice = 0; indice < longitud; indice++) {
            System.out.print("Valor [" + indice + "]: ");
            nuevoArreglo[indice] = lector.nextInt();
        }
        return nuevoArreglo;
    }

    /**
     * Metodo 5: carga datos en un arreglo pasado por parametro.
     *
     * @param arregloDestino arreglo a rellenar
     * @param lector         scanner
     * @return arreglo modificado (por comodidad en cadena fluida)
     */
    public static int[] mCargarEn(int[] arregloDestino, Scanner lector) {
        for (int indice = 0; indice < arregloDestino.length; indice++) {
            System.out.print("Valor [" + indice + "]: ");
            arregloDestino[indice] = lector.nextInt();
        }
        return arregloDestino;
    }

    /* ======= OPERACIONES BASICAS ======= */

    /**
     * Metodo 6: asigna un valor a la posicion indicada.
     *
     * @param indice posicion (0‑based)
     * @param valor  nuevo valor
     */
    public void mAsignar(int indice, int valor) {
        if (indice < 0 || indice >= datos.length) {
            return;
        }
        datos[indice] = valor;
    }

    /** Metodo 7: imprime el arreglo interno. */
    public void mImprimir() {
        mImprimir(datos);
    }

    /**
     * Metodo 8: imprime cualquier arreglo recibido.
     *
     * @param arreglo arreglo a mostrar
     */
    public static void mImprimir(int[] arreglo) {
        System.out.print("[");
        for (int indice = 0; indice < arreglo.length; indice++) {
            System.out.print(arreglo[indice]);
            if (indice < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Metodo 9: suma los elementos del arreglo interno.
     *
     * @return suma total
     */
    public int mSumar() {
        return mSumar(datos);
    }

    /**
     * Metodo 10: suma los elementos de un arreglo recibido.
     *
     * @param arreglo arreglo a sumar
     * @return suma total
     */
    public static int mSumar(int[] arreglo) {
        int total = 0;
        for (int valor : arreglo) {
            total += valor; // operador +=
        }
        return total;
    }

    /**
     * Metodo 11: suma posicion a posicion dos arreglos.
     *
     * @param primerArreglo  primer arreglo
     * @param segundoArreglo segundo arreglo
     * @return nuevo arreglo con las sumas
     */
    public static int[] mSumarElementoAPosicion(int[] primerArreglo,
                                                int[] segundoArreglo) {
        int longitudComun = Math.min(primerArreglo.length, segundoArreglo.length);
        int[] resultado = new int[longitudComun];
        for (int indice = 0; indice < longitudComun; indice++) {
            resultado[indice] = primerArreglo[indice] + segundoArreglo[indice];
        }
        return resultado;
    }

    /**
     * Metodo 12: suma de los numeros pares del arreglo interno.
     *
     * @return suma de pares
     */
    public int mSumarPares() {
        int sumaPares = 0;
        for (int valor : datos) {
            if (valor % 2 == 0) {
                sumaPares += valor;
            }
        }
        return sumaPares;
    }

    /**
     * Metodo 13: suma de los numeros impares del arreglo interno.
     *
     * @return suma de impares
     */
    public int mSumarImpares() {
        int sumaImpares = 0;
        for (int valor : datos) {
            if (valor % 2 != 0) {
                sumaImpares += valor;
            }
        }
        return sumaImpares;
    }

    /**
     * Metodo 14: menor valor presente en el arreglo.
     *
     * @return valor minimo
     */
    public int mMenor() {
        int minimo = datos[0];
        for (int valor : datos) {
            if (valor < minimo) {
                minimo = valor;
            }
        }
        return minimo;
    }

    /**
     * Metodo 15: mayor valor presente en el arreglo.
     *
     * @return valor maximo
     */
    public int mMayor() {
        int maximo = datos[0];
        for (int valor : datos) {
            if (valor > maximo) {
                maximo = valor;
            }
        }
        return maximo;
    }

    /**
     * Devuelve la referencia interna del arreglo.
     *
     * @return arreglo interno
     */
    public int[] mGetDatos() {
        return datos;
    }
}
