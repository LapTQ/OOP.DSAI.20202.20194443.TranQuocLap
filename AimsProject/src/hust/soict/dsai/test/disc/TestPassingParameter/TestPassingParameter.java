package hust.soict.dsai.test.disc.TestPassingParameter;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // The correct swap function
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        DigitalVideoDisc tmp = new DigitalVideoDisc("Untitle");
        changeAttributes(tmp, dvd1);
        changeAttributes(dvd1, dvd2);
        changeAttributes(dvd2, tmp);
    }

    public static void changeAttributes(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setCost(dvd2.getCost());
    }

    public static Object getItself(Object o) {
        return o;
    }

    private static void changeTitle(DigitalVideoDisc dvd, String title) {
        String odlTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(odlTitle);
    }
}
