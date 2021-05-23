package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.DuplicateException;
import hust.soict.dsai.aims.exception.PlayerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {

    private String artist;
    public ObservableList<Track> tracks = FXCollections.observableArrayList();

    public String getArtist() {
        return artist;
    }

    public ObservableList<Track> getTracks() {
        return tracks;
    }

    public CompactDisc() {
        super(null, null, 0);
    }
    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
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

    public CompactDisc(String title, String artist, ObservableList<Track> tracks) {
        super(title);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, ObservableList<Track> tracks) {
        super(title, category, cost);
        this.tracks = tracks;
    }

    public CompactDisc(String title, String director, String artist, ObservableList<Track> tracks) {
        super(title, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, ObservableList<Track> tracks) {
        super(title);
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, String artist, ObservableList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, String director, String artist, ObservableList<Track> tracks) {
        super(title, category, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist, ObservableList<Track> tracks) {
        super(title, category, cost, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, director);
        this.artist = artist;
    }

    public int findTrack(Track track) {
        int i = 0;
        while (i < this.tracks.size() && !this.tracks.get(i).getTitle().equals(track.getTitle())) {
            i += 1;
        }
        return i;
    }

    public void addTrack(Track track) throws DuplicateException {

        int i = this.findTrack(track);

        if (i < this.tracks.size()) {
            System.out.println(track.getTitle() + " is already included.");
            throw new DuplicateException("ERROR: Duplicated Media!");
        } else {
            this.tracks.add(track);
            System.out.println(track.getTitle() + " is added successfully.");
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

    public String play() throws PlayerException {

        String msg = "";

        if (this.getLength() > 0) {
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    msg += nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println(msg);

        return msg;
    }

    public String toString() {
        String msg = "ID: " + this.getId() + "\t" + "Title: " + this.getTitle() + "\t" + "Category: " + this.getCategory() + "\t" + "Director: " + this.getDirector() + "\t" + "Artist: " + this.getArtist() + "\t" + "n_Tracks: " + this.getTracks().size() + "Cost: " + this.getCost();
        System.out.println(msg);
        return msg;
    }
}
