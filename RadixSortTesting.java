import java.io.*;
import java.util.*;

public class RadixSortTesting {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de números:");
        int n = sc.nextInt();
        int[] numeros = new int[n];

        System.out.println("Ingrese los números:");
        for (int i = 0; i < n; i++) {
            numeros[i] = sc.nextInt();
        }

        System.out.println("Lista original:");
        RadixSort.imprimirArreglo(numeros);

        // Ordenar
        RadixSort.radixSort(numeros);

        System.out.println("Lista ordenada:");
        RadixSort.imprimirArreglo(numeros);

        // Guardar salida en archivo
        RadixSort.guardarEnArchivo(numeros, "salida.txt");
        System.out.println("La lista ordenada se guardó en salida.txt");
        sc.close();
    }
}