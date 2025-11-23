public class RadixSortTesting {
    public static void main(String[] args) {
        int[] numeros = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Lista original:");
        RadixSort.imprimirArreglo(numeros);

        RadixSort.radixSort(numeros);

        System.out.println("Lista ordenada:");
        RadixSort.imprimirArreglo(numeros);
    }
}