package Sorts;

import java.util.*;

public class MergeSort <T extends Comparable<T>> {
    public List<T> sort (List<T> list, Comparator<T> comparator) {
        int izq = 0;
        int der = list.size() - 1;


        if (izq < der) {
            int mid = (izq + der) / 2;

            sort(list, izq, mid, comparator); // primera mitad
            sort(list, mid + 1, der, comparator); // segunda mitad

            merge(list, izq, mid, der, comparator);
        }

        return new ArrayList<>(list);
    }

    public void sort (List<T> list, int izq, int der, Comparator<T> comparator) {
        if (izq < der) {
            int mid = (izq + der) / 2;

            sort(list, izq, mid, comparator); // primera mitad
            sort(list, mid + 1, der, comparator); // segunda mitad

            merge(list, izq, mid, der, comparator);
        }
    }

    void merge(List<T> list, int izq, int mid, int end, Comparator<T> comparator) {
        T[] arrayIzq  = (T[]) new Comparable[mid - izq + 1];
        T[] arrayDer = (T[]) new Comparable[end - mid];

        for (int i = 0; i < arrayIzq.length; ++i) {
            arrayIzq[i] = list.get(izq + i);
        }

        for (int i = 0; i < arrayDer.length; ++i) {
            arrayDer[i] = list.get(mid + 1 + i);
        }

        int indiceIzq = 0, indiceDer = 0, actual = izq;

        while (indiceIzq < arrayIzq.length && indiceDer < arrayDer.length) {
            if (comparator.compare(arrayIzq[indiceIzq], arrayDer[indiceDer]) <= 0) {
                list.set(actual, arrayIzq[indiceIzq]);
                indiceIzq++;
            } else {
                list.set(actual, arrayDer[indiceDer]);
                indiceDer++;
            }
            actual++;
        }

        while (indiceIzq < arrayIzq.length)  list.set(actual++, arrayIzq[indiceIzq++]);
        while (indiceDer < arrayDer.length)  list.set(actual++, arrayDer[indiceDer++]);
    }
}