import java.util.*;

public class HeapSort <T extends Comparable<T>> {
    public List<T> sort(List<T> list, Comparator<T> comparator) {
        Heap<T> heap = new Heap<>();

        for (T val : list) {
            heap.add(val, comparator);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            list.set(i, heap.remove(comparator));
        }

        return new ArrayList<>(list);

    }
}

