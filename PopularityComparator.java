import java.util.*;

public class PopularityComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Track t1 = (Track) o1;
        Track t2 = (Track) o2;

        if (t1.getPopularity() == t2.getPopularity()) return 0;
        else if (t1.getPopularity() > t2.getPopularity()) return 1;
        else return -1;
    }
}