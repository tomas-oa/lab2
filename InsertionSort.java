import java.util.*;

public class InsertionSort <T extends Comparable<T>> {
    public List<T> sort(List<T> list, Comparator<T> comparator) {
        int i, x = 0;
        T key;

        for (i = 1; i < list.size(); i++) {
            key = list.get(i);
            x = i - 1;

            while (0 <= x && comparator.compare(list.get(x), key) > 0) {
                list.set(x+1, list.get(x));
                x--;
            }
            list.set(x + 1, key);
        }

        return new ArrayList<>(list);
    }
}
