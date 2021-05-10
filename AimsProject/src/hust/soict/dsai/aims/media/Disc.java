package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.playable.Playable;

public abstract class Disc extends Media implements Playable {

    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String director) {
        super(title);
        this.director = director;
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, String director) {
        super(title, category);
        this.director = director;
    }

    public Disc(String title, String category, float cost, String director) {
        super(title, category, cost);
        this.director = director;
    }

    public String toString() {
        String msg = "ID: " + this.getId() + "\t" + "Title: " + this.getTitle() + "\t" + "Category: " + this.getCategory() + "\t" + "Director: " + this.getDirector() + "\t" + "Cost: " + this.getCost();
        System.out.println(msg);
        return msg;
    }

}
