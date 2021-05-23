package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.comparator.MediaComparatorByTitleCost;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public abstract class Media {

    public static int nMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;
    private String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
        id = nMedia;
        nMedia += 1;
    }

    public Media(String title, String category) {
        this(title);
        this.category = category;
    }

    public Media(String title, String category, float cost) {
        this(title, category);
        this.cost = cost;
    }

    public boolean equals(Object o) {
        Media other = (Media) o;

        return this.title.equals(other.getTitle());
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
