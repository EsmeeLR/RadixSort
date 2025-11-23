public class RadixSort {

    // Método principal
    public static void radixSort(int[] arr) {
        int max = obtenerMaximo(arr);

        // Aplicar counting sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortPorDigito(arr, exp);
        }
    }

    // Obtener el valor máximo del arreglo
    private static int obtenerMaximo(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}