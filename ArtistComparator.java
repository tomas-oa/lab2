package Comparators;

import java.util.*;

public class ArtistComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Track t1 = (Track) o1;
        Track t2 = (Track) o2;

        return t1.getArtist().compareTo(t2.getArtist());
    }
}