public class RadixSort {

    // Método principal
    public static void radixSort(int[] arr) {
        int max = obtenerMaximo(arr);

        // Aplicamos counting sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortPorDigito(arr, exp);
        }
    }

    // Obtenemos el valor máximo del arreglo
    private static int obtenerMaximo(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    private static void countingSortPorDigito(int[] arr, int exp) {
        int n = arr.length;
        int[] salida = new int[n];
        int[] conteo = new int[10];

        // Contamos ocurrencias
        for (int i = 0; i < n; i++) {
            int digito = (arr[i] / exp) % 10;
            conteo[digito]++;
        }

        // Acumulamos conteo
        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        // Construimos arreglo de salida
        for (int i = n - 1; i >= 0; i--) {
            int digito = (arr[i] / exp) % 10;
            salida[conteo[digito] - 1] = arr[i];
            conteo[digito]--;
        }

        // Copiamos al arreglo original
        for (int i = 0; i < n; i++) {
            arr[i] = salida[i];
        }
    }

    // Finción para poder imprimir el arreglo
    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}