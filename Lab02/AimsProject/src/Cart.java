public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered == 20) {
            System.out.println("Cart is already full!");
        }
        else {
            this.itemsOrdered[qtyOrdered] = disc;
            this.qtyOrdered += 1;
            System.out.println(disc.getTitle() + " added successfully!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered == 0) {
            System.out.println("Cart is already empty!");
        }
        else {
            int i = 0;
            while (i < qtyOrdered && this.itemsOrdered[i] != disc) {
                i += 1;
            }
            if (i == this.qtyOrdered) {
                System.out.println(disc.getTitle() + " not in cart!");
            }
            else {
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
}
