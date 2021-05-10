package hust.soict.dsai.aims.comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int byCost = (o2.getCost() - o1.getCost()) > 0 ? 1 : -1;
        int byTitle = o1.getTitle().compareTo(o2.getTitle());
        return (byTitle == 0) ? byCost : byTitle;
    }
}
