package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {

        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.print("Total cost is: ");
        System.out.println(anOrder.totalCost());

        System.out.println("Trying to remove " + dvd2.getTitle());
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

        DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3};
        anOrder.addDigitalVideoDisc(dvdList);

        System.out.print(anOrder.totalCost());
    }
}