import java.util.Scanner;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("Cart is already full!");
        }
        else {
            this.itemsOrdered[qtyOrdered] = disc;
            this.qtyOrdered += 1;
            System.out.println(disc.getTitle() + " added successfully!");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        if (dvdList.length + this.qtyOrdered > MAX_NUMBERS_ORDERED) {
            System.out.println("Adding this list will cause overflow. Continue? [Y/n] ");
            Scanner scan = new Scanner(System.in);
            String confirm = scan.next();
            if (!(confirm == "y" || confirm == "Y")) {
                return;
            }
        }
        for(int i = 0; i < dvdList.length && this.qtyOrdered == MAX_NUMBERS_ORDERED; i++) {
            this.addDigitalVideoDisc(dvdList[i]);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd, DigitalVideoDisc... dvdList) {
        for(int i = 0; i < dvdList.length && this.qtyOrdered == MAX_NUMBERS_ORDERED; i++) {
            this.addDigitalVideoDisc(dvdList[i]);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        DigitalVideoDisc dvdList[] = {dvd1, dvd2};
        this.addDigitalVideoDisc(dvdList);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered == 0) {
            System.out.println("Cart is already empty!");
        }
        else {
            int i = this.search(disc.getId());
            System.out.print("Remove: ");
            this.printSearchResult(i);
            if (i != -1) {
                DigitalVideoDisc temp;
                temp = this.itemsOrdered[i];
                this.itemsOrdered[i] = this.itemsOrdered[this.qtyOrdered - 1];
                this.itemsOrdered[this.qtyOrdered - 1] = temp;
                this.qtyOrdered -= 1;
            }
        }
    }

    public float totalCost() {
        float total = 0;
        for(int i = 0; i < this.qtyOrdered; i ++) {
            total += this.itemsOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < this.qtyOrdered; i ++) {
            System.out.println(this.itemsOrdered[i].getDetail());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
    }

    public int search(int id) {
        int i = 0;
        while (i < qtyOrdered && this.itemsOrdered[i].getId() != id) {
            i += 1;
        }
        this.printSearchResult(i);
        if (i == this.qtyOrdered) {
            return -1;
        }
        return i;
    }

    public int search(String title) {
        int i = 0;
        while (i < qtyOrdered && this.itemsOrdered[i].getTitle() != title) {
            i += 1;
        }
        this.printSearchResult(i);
        if (i == this.qtyOrdered) {
            return -1;
        }
        return i;
    }

    public void printSearchResult(int i) {
        if (0 > i || i >= this.qtyOrdered) {
            System.out.println("Item not found! Please check your id or regex again!");
        }
        else {
            DigitalVideoDisc dvd = this.itemsOrdered[i];
            System.out.println(dvd.getId() + ": " + dvd.getDetail() + " in cart!");
        }
    }
}
