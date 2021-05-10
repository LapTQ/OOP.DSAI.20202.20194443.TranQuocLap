package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public int findMedia(Media media) {

        int i = 0;
        while (i < this.itemsOrdered.size() && this.itemsOrdered.get(i) != media) {
            i += 1;
        }

        return i;
    }

    public void addMedia(Media media) {
        int i = this.findMedia(media);

        if (i < this.itemsOrdered.size()) {
            System.out.println(media.getTitle() + " is already included.");
        } else if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println(media.getTitle() + " added to cart unsuccessfully (Cart is already full)!");
        } else {
            this.itemsOrdered.add(media);
            System.out.println(media.getTitle() + " added to cart successfully!");
        }
    }

    public void addMedia(Media[] mediaList) {
        if (mediaList.length + this.itemsOrdered.size() > MAX_NUMBERS_ORDERED) {
            System.out.println("Adding this list might cause overflow. Some of medias might be skipped.\nContinue? [Y/n] ");
            Scanner scan = new Scanner(System.in);
            String confirm = scan.next();
            if (!(confirm == "y" || confirm == "Y")) {
                return;
            }
        }
        for (int i = 0; i < mediaList.length && this.itemsOrdered.size() == MAX_NUMBERS_ORDERED; i++) {
            this.addMedia(mediaList[i]);
        }
    }

    public void addMedia(Media media, Media... mediaList) {
        this.addMedia(media);
        for (int i = 0; i < mediaList.length && this.itemsOrdered.size() == MAX_NUMBERS_ORDERED; i++) {
            this.addMedia(mediaList[i]);
        }
    }

    public void addMedia(Media media1, Media media2) {
        Media mediaList[] = {media1, media2};
        this.addMedia(mediaList);
    }

    public void removeMedia(Media media) {

        int i = this.findMedia(media);

        if (this.itemsOrdered.size() == 0) {
            System.out.println("Cart is already empty!");
        } else if (i < this.itemsOrdered.size()) {
            this.itemsOrdered.remove(i);
            System.out.println(media.getTitle() + " is removed successfully");
        } else {
            System.out.println(media.getTitle() + " not found");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            total += this.itemsOrdered.get(i).getCost();
        }
        return total;
    }

//    public void print() {
//        System.out.println("***********************CART***********************");
//        for (int i = 0; i < this.itemsOrdered.size(); i ++) {
//            System.out.println(this.itemsOrdered.get(i).getTitle() + get);
//        }
//        System.out.println("Total cost: " + this.totalCost());
//        System.out.println("***************************************************");
//    }
//
//    public int search(int id) {
//        int i = 0;
//        while (i < this.itemsOrdered.size() && this.itemsOrdered.get(i).getId() != id) {
//            i += 1;
//        }
//        this.printSearchResult(i);
//        if (i == this.itemsOrdered.size()) {
//            return -1;
//        }
//        return i;
//    }
//
//    public int search(String title) {
//        int i = 0;
//        while (i < this.itemsOrdered.size() && this.itemsOrdered.get(i).getTitle() != title) {
//            i += 1;
//        }
//        this.printSearchResult(i);
//        if (i == this.itemsOrdered.size()) {
//            return -1;
//        }
//        return i;
//    }
//
//    public void printSearchResult(int i) {
//        if (0 > i || i >= this.itemsOrdered.size()) {
//            System.out.println("Item not found! Please check your id or regex again!");
//        }
//        else {
//            DigitalVideoDisc dvd = this.itemsOrdered.get(i);
//            System.out.println(dvd.getId() + ": " + dvd.getDetail() + " in cart!");
//        }
//    }
}
