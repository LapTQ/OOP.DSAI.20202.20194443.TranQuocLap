package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.exception.DuplicateException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 87, "Roger Allers", 19);
        try {
            store.addMedia(dvd1);
        } catch (DuplicateException e) {
            e.printStackTrace();
        }

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 87, "George Lucas", 24);
        try {
            store.addMedia(dvd2);
        } catch (DuplicateException e) {
            e.printStackTrace();
        }

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        try {
            store.addMedia(dvd3);
        } catch (DuplicateException e) {
            e.printStackTrace();
        }

        store.removeMedia(dvd2);
    }
}
