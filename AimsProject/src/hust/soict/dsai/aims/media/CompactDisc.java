package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public CompactDisc(String title, String director, String artist) {
        super(title, director);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, String artist) {
        super(title, category, director);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, director);
        this.artist = artist;
    }

    public CompactDisc(String title, List<Track> tracks) {
        super(title);
        this.tracks = tracks;
    }

    public CompactDisc(String title, String director, List<Track> tracks) {
        super(title, director);
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, List<Track> tracks) {
        super(title, category, cost);
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, String director, List<Track> tracks) {
        super(title, category, director);
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, String director, List<Track> tracks) {
        super(title, category, cost, director);
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, String director, String artist, List<Track> tracks) {
        super(title, category, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist, List<Track> tracks) {
        super(title, category, cost, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public int findTrack(Track track) {

        int i = 0;
        while (i < this.tracks.size() && !this.tracks.get(i).getTitle().equals(track.getTitle())) {
            i += 1;
        }

        return i;
    }

    public void addTrack(Track track) {

        int i = this.findTrack(track);

        if (i < this.tracks.size()) {
            this.tracks.add(track);
            System.out.println(track.getTitle() + " is added successfully.");
        } else {
            System.out.println(track.getTitle() + " is already included.");
        }
    }

    public void removeTrack(Track track) {

        int i = this.findTrack(track);

        if (i < this.tracks.size()) {
            this.tracks.remove(i);
            System.out.println(track.getTitle() + " is removed successfully");
        } else {
            System.out.println(track.getTitle() + " not found");
        }
    }

    public float getLength() {

        float total_length = 0;

        for (int i = 0; i < this.tracks.size(); i++) {
            total_length += this.tracks.get(i).getLength();
        }

        return total_length;
    }

    public void play() {
        float min_length = 1e9F;

        for (int i = 0; i < this.tracks.size(); i++) {
            if (min_length > this.tracks.get(i).getLength()) {
                min_length = this.tracks.get(i).getLength();
            }
        }

        if (min_length > 0) {
            System.out.println("Playing CompactDisc: " + this.getTitle() + "\t" + "Category: " + this.getCategory() + "\t" + "Artist: " + this.artist);
            for (int i = 0; i < this.tracks.size(); i++) {
                this.tracks.get(i).play();
            }
        } else {
            System.out.println("Can't play.");
        }
    }

    public String toString() {
        String msg = "ID: " + this.getId() + "\t" + "Title: " + this.getTitle() + "\t" + "Category: " + this.getCategory() + "\t" + "Director: " + this.getDirector() + "\t" + "Artist: " + this.getArtist() + "\t" + "n_Tracks: " + this.getTracks().size() + "Cost: " + this.getCost();
        System.out.println(msg);
        return msg;
    }
}
