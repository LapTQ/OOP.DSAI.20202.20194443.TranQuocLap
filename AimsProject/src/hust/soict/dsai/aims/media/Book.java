package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private int length;
    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, List<String> authors) {
        super(title);
        this.authors = authors;
    }

    public Book(String title, String category, List<String> authors) {
        super(title, category);
        this.authors = authors;
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(String title, int length, List<String> authors) {
        super(title);
        this.length = length;
        this.authors = authors;
    }

    public Book(String title, String category, int length, List<String> authors) {
        super(title, category);
        this.length = length;
        this.authors = authors;
    }

    public Book(String title, String category, float cost, int length, List<String> authors) {
        super(title, category, cost);
        this.length = length;
        this.authors = authors;
    }

    public void addAuthor(String authorName) {

        int i = this.findAuthor(authorName);

        if (i < this.authors.size()) {
            this.authors.add(authorName.toLowerCase());
            System.out.println(authorName + " is successfully added to author list.");
        } else {
            System.out.println(authorName + " is already included.");
        }
    }

    public void removeAuthor(String authorName) {

        int i = this.findAuthor(authorName);

        if (i < this.authors.size()) {
            this.authors.remove(i);
            System.out.println(authorName + " is successfully removed from author list.");
        } else {
            System.out.println(authorName + " not found.");
        }
    }

    private int findAuthor(String authorName) {

        int i = 0;
        while (i < this.authors.size() && this.authors.get(i) != authorName.toLowerCase()) {
            i += 1;
        }

        return i;
    }

    @Override
    public String toString() {
        String msg = "ID: " + this.getId() + "\t" + "Title: " + this.getTitle() + "\t" + "Category: " + this.getCategory() + "\t" + "Authors: " + this.getAuthors() + "\t" + "Cost: " + this.getCost();
        System.out.println(msg);
        return msg;
    }
}
