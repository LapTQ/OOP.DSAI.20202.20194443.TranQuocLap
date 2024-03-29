package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static final int MAX_NUMBER = 10000000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public int findMedia(Media media) {

        int i = 0;
        while (i < this.itemsInStore.size() &&
                !this.itemsInStore.get(i).getTitle().equals(media.getTitle())) {
            i += 1;
        }

        return i;
    }

    public void addMedia(Media media) throws DuplicateException {
        int i = this.findMedia(media);

        if (i < this.itemsInStore.size()) {
            System.out.println(media.getTitle() + " is already included.");
            throw new DuplicateException("ERROR: Media already included!");
        } else if (this.itemsInStore.size() == MAX_NUMBER) {
            System.out.println(media.getTitle() + " added unsuccessfully (Store is already full)!");
        } else {
            this.itemsInStore.add(media);
            System.out.println(media.getTitle() + " added successfully!");
        }
    }

    public void removeMedia(Media media) {

        int i = this.findMedia(media);

        if (this.itemsInStore.size() == 0) {
            System.out.println("Cart is already empty!");
        } else if (i < this.itemsInStore.size()) {
            this.itemsInStore.remove(i);
            System.out.println(media.getTitle() + " is removed successfully");
        } else {
            System.out.println(media.getTitle() + " not found");
        }
    }
}
