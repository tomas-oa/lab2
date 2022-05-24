public class SelectionSortGenerics {
    private <T> void swap(T[] array, int i, int j) {
        if (i != j) {
            T aux = array[i];
            array[i] = array[j];
            array[j] = aux;
        }
    }

    public <T extends Comparable <T> > void sort(T[] arr) {

        long comienzo = System.nanoTime();

        for (int i = 0; i < arr.length; i++) {
            int menor = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[menor]) <= 0) {
                    menor = j;
                }
            }

            swap(arr, i, menor);
        }

        long fin = System.nanoTime();

        long tiempo = (fin - comienzo);

        System.out.println("demoró " + tiempo + " ns");
    }
}
