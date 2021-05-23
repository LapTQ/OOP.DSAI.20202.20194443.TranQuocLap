package hust.soict.dsai.test.cart.CartTest;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.DuplicateException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 87, "Roger Allers", 19);
        try {
            cart.addMedia(dvd1);
        } catch (DuplicateException e) {
            e.printStackTrace();
        }

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 87, "George Lucas", 24);
        try {
            cart.addMedia(dvd2);
        } catch (DuplicateException e) {
            e.printStackTrace();
        }

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        try {
            cart.addMedia(dvd3);
        } catch (DuplicateException e) {
            e.printStackTrace();
        }

//        cart.print();
//        cart.search(2);
//        cart.search("Aladin");
//        cart.search("StarWars");
    }
}
