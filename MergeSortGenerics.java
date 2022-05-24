public class MergeSortGenerics <T extends Comparable <T>> {
    void sort(T[] array, int izq, int der)
    {
        long comienzo = System.nanoTime();

        if (izq < der)
        {
            int mid = (izq + der) / 2;

            sort(array, izq, mid); // sort first half
            sort(array, mid + 1, der);  // sort second half

            merge(array, izq, mid, der);
        }

        long fin = System.nanoTime();
        long tiempo = (fin - comienzo);

        System.out.println("demoró: " + tiempo);
    }

    void merge(T[] array, int izq, int mid, int end)
    {
        T[] arrayIzq  = (T[]) new Comparable[mid - izq + 1];
        T[] arrayDer = (T[]) new Comparable[end - mid];

        for (int i = 0; i < arrayIzq.length; ++i)
            arrayIzq[i] = array[izq + i];

        for (int i = 0; i < arrayDer.length; ++i)
            arrayDer[i] = array[mid + 1 + i];

        int indiceIzq = 0, indiceDer = 0;
        int actual = izq;

        while (indiceIzq < arrayIzq.length && indiceDer < arrayDer.length)
        {
            if (arrayIzq[indiceIzq].compareTo(arrayDer[indiceDer]) <= 0)
            {
                array[actual] = arrayIzq[indiceIzq];
                indiceIzq++;
            }
            else
            {
                array[actual] = arrayDer[indiceDer];
                indiceDer++;
            }
            actual++;
        }

        while (indiceIzq < arrayIzq.length) array[actual++] = arrayIzq[indiceIzq++];
        while (indiceDer < arrayDer.length) array[actual++] = arrayDer[indiceDer++];
    }
}
