package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.playable.Playable;

public class Track implements Playable {

    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
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
    public String play() throws PlayerException {

        String msg = "";

        if (length > 0) {
            msg = "Playing track: " + this.getTitle();
            msg = msg + "\n" + "... with length: " + this.getLength();
            System.out.println(msg);
        }
        else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

        return msg;
    }

    public boolean equals(Object o) {
        Track other = (Track) o;

        return (this.title == other.getTitle() && this.length == other.getLength());
    }

}
