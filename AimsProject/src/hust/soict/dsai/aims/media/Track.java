package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.playable.Playable;

public class Track implements Playable {

    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public float getLength() {
        return length;
    }

    public Track(String title) {
        this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("... with length: " + this.getLength());
    }

    public boolean equals(Object o) {
        Track other = (Track) o;

        return (this.title == other.getTitle() && this.length == other.getLength());
    }
}
