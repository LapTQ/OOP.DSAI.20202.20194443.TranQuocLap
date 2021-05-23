package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc {

    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String director) {
        super(title, director);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category, director);
    }

    public DigitalVideoDisc(String title, String category, float cost, String director) {
        super(title, category, cost, director);
    }

    public DigitalVideoDisc(String title, int length) {
        super(title);
        this.length = length;
    }

    public DigitalVideoDisc(String title, String director, int length) {
        super(title, director);
        this.length = length;
    }

    public DigitalVideoDisc(String title, String category, float cost, int length) {
        super(title, category, cost);
        this.length = length;
    }

    public DigitalVideoDisc(String title, String category, String director, int length) {
        super(title, category, director);
        this.length = length;
    }

    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        super(title, category, cost, director);
        this.length = length;
    }

    public String play() throws PlayerException {

        String msg = "";
        if (this.getLength() > 0) {
            msg = "Playing DVD: " + this.getTitle();
            msg = msg + "\n" + "DVD length: " + this.getLength();
            System.out.println(msg);
        } else {
            throw new PlayerException("ERROR: DVD length is not positive!");
        }


        return msg;
    }
}
