import java.util.*;
class Heap <T extends Comparable<T>> {
    private final ArrayList<T> heapArray = new ArrayList<>();

    public Heap() {}

    public void add(T value) {
        heapArray.add(value);
        int actual = heapArray.size() - 1;

        while (actual > 0) {
            int padre = (actual - 1) / 2;

            if (heapArray.get(actual).compareTo(heapArray.get(padre)) > 0) {
                T aux = heapArray.get(actual);
                heapArray.set(actual, heapArray.get(padre));
                heapArray.set(padre, aux);
            } else {
                break;
            }

            actual = padre;
        }
    }

    public T remove() {
        if (heapArray.isEmpty()) { return null; }

        T temp = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size() - 1));
        heapArray.remove(heapArray.size() - 1);

        int actual = 0;
        while (actual < heapArray.size()) {
            int hijoIzq = 2 * actual + 1;
            int hijoDer = 2 * actual + 2;

            if (hijoIzq >= heapArray.size()) { break; }

            int mayor = hijoIzq;

            if (hijoDer < heapArray.size()) {
                if (heapArray.get(mayor).compareTo(heapArray.get(hijoDer)) < 0) {
                    mayor = hijoDer;
                }
            }

            if (heapArray.get(actual).compareTo(heapArray.get(mayor)) < 0) {
                T aux = heapArray.get(mayor);
                heapArray.set(mayor, heapArray.get(actual));
                heapArray.set(actual, aux);
                actual = mayor;
            } else {
                break;
            }
        }

        return temp;
    }

    public int getSize() { return heapArray.size(); }
}

class HeapSortGenerics {
    public static <T extends Comparable<T>> void heapSort(T[] array) {

        long comienzo = System.nanoTime();

        Heap <T> heap = new Heap<>();

        for (T val : array) {
            heap.add(val);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = heap.remove();
        }

        long fin = System.nanoTime();
        long total = (fin - comienzo);

        System.out.println("demoró " + total + " ns");
    }
}