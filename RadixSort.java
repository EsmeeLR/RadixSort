import java.io.*;

public class RadixSort {

    public static void radixSort(int[] arr) {
        int max = obtenerMaximo(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortPorDigito(arr, exp);
        }
    }

    private static int obtenerMaximo(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }

    private static void countingSortPorDigito(int[] arr, int exp) {
        int n = arr.length;
        int[] salida = new int[n];
        int[] conteo = new int[10];

        for (int i = 0; i < n; i++) conteo[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++) conteo[i] += conteo[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            int digito = (arr[i] / exp) % 10;
            salida[conteo[digito] - 1] = arr[i];
            conteo[digito]--;
        }
        for (int i = 0; i < n; i++) arr[i] = salida[i];
    }

    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    // Guardar arreglo en archivo
    public static void guardarEnArchivo(int[] arr, String nombreArchivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
        for (int num : arr) {
            bw.write(num + " ");
        }
        bw.close();
    }
}