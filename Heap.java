import java.util.*;

public class Heap <T extends Comparable<T>> {
    private ArrayList<T> heapArray = new ArrayList<>();

    public Heap() {}

    public void add(T value, Comparator<T> comparator) {
        heapArray.add(value);
        int actual = heapArray.size() - 1;

        while (actual > 0) {
            int padre = (actual - 1) / 2;

            if (comparator.compare(heapArray.get(actual), heapArray.get(padre)) > 0) {
                T aux = heapArray.get(actual);
                heapArray.set(actual, heapArray.get(padre));
                heapArray.set(padre, aux);
            } else {
                break;
            }

            actual = padre;
        }
    }

    public T remove(Comparator<T> comparator) {
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
                if (comparator.compare(heapArray.get(mayor), heapArray.get(hijoDer)) < 0) {
                    mayor = hijoDer;
                }
            }

            if (comparator.compare(heapArray.get(actual), heapArray.get(mayor)) < 0) {
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
}