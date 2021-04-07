package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
    private static final int MAX_NUMBER = 10000000;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBER];
    private int qty = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (this.qty == MAX_NUMBER) {
            System.out.println("Sorry! Our store is full! :-D");
        }
        else {
            this.itemsInStore[qty] = disc;
            this.qty += 1;
            System.out.println(disc.getTitle() + " added successfully!");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        System.out.println("Trying removing " + disc.getTitle() + " from our store...");
        if (this.qty == 0) {
            System.out.println("Our store is empty! Please come here and sell something!");
        }
        else {
            int i = 0;
            while (i < qty && this.itemsInStore[i].getId() != disc.getId()) {
                i += 1;
            }
            if (i == this.qty) {
                System.out.println("This DVD is not in here. Give it to us :-D");
            }
            else {
                DigitalVideoDisc temp;
                temp = this.itemsInStore[i];
                this.itemsInStore[i] = this.itemsInStore[this.qty - 1];
                this.itemsInStore[this.qty - 1] = temp;
                this.qty -= 1;
                System.out.println("Item is successfully removed from store! :-(");
            }
        }
    }
}
