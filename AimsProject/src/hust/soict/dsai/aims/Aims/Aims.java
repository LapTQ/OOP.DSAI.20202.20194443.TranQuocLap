package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store.Store;

import java.util.*;

public class Aims {

    private static Store store = new Store();
    private static Scanner scan = new Scanner(System.in);
    private static int choice;
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        AIMS();
        System.out.println("Thanks for visiting! :>");
        System.out.println("But don't visit again. -.- I'm so tired to welcome you.");
    }

    public static void AIMS() {
        while (true) {
            System.out.println(" *** Welcome to AIMS *** ");
            System.out.println("-------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("-------------------------------");

            scan = new Scanner(System.in);
            choice = scan.nextInt();
            if (choice == 1) {
                ViewStore();
            } else if (choice == 2) {
                UpdateStore();
            } else if (choice == 3) {
                SeeCurrentCart();
            } else {
                break;
            }
        }
    }

    public static void ViewStore() {
        while (true) {
            // Display all items in store
            System.out.println(" *** View store *** ");
            int i = 0;
            for (Media e : store.getItemsInStore()) {
                i += 1;
                System.out.print(i + ". ");
                e.toString();
            }

            System.out.println("-------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Exit");
            System.out.println("-------------------------------");

            scan = new Scanner(System.in);
            choice = scan.nextInt();
            if (choice == 1) {
                SeeMediaDetails();
            } else if (choice == 2) {
                AddMediaToCart();
            } else if (choice == 3) {
                PlayAMedia();
            } else if (choice == 4) {
                SeeCurrentCart();
            } else {
                break;
            }
        }
    }

    private static void SeeCurrentCart() {
        while (true) {
            // Display all items in current cart
            System.out.println(" *** See current cart *** ");
            int i = 0;
            for (Media e : cart.getItemsOrdered()) {
                i += 1;
                System.out.print(i + ". ");
                e.toString();
            }

            System.out.println("-------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Exit");
            System.out.println("-------------------------------");

            scan = new Scanner(System.in);
            choice = scan.nextInt();
            if (choice == 1) {
                FilterMediaInCart();
            } else if (choice == 2) {
                SortMediaInCart();
            } else if (choice == 3) {
                RemoveMediaFromCart();
            } else if (choice == 4) {
                PlayAMedia();
            } else if (choice == 5) {
                PlaceOrder();
            } else {
                break;
            }
        }
    }

    private static void UpdateStore() {
        while (true) {
            System.out.println(" *** Update store *** ");
            System.out.println("-------------------------------");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Exit");
            System.out.println("-------------------------------");

            scan = new Scanner(System.in);
            choice = scan.nextInt();
            if (choice == 1) {
                AddMediatoStore();
            } else if (choice == 2) {
                RemoveMediaFromStore();
            } else {
                break;
            }
        }
    }

    private static void RemoveMediaFromStore() {
        while (true) {
            System.out.print("Enter exact media title [0 to exit]: ");

            scan = new Scanner(System.in);
            String title = scan.nextLine().toLowerCase().strip();

            choice = (title.equals("0")) ? 0 : searchStoreByTitle(title);
            if (choice == 0) {
                break;
            }

            if (choice == -1) {
                System.out.println("Media title not found.");
            } else {
                choice -= 1; // index in array
                Media item = store.getItemsInStore().get(choice);
                store.removeMedia(item);
            }
        }
    }

    private static void AddMediatoStore() {
        while (true) {
            System.out.println(" *** Add a media to store *** ");
            System.out.println("-------------------------------");
            System.out.println("1. Book");
            System.out.println("2. DVD");
            System.out.println("3. CD");
            System.out.println("0. Exit");
            System.out.println("-------------------------------");


            scan = new Scanner(System.in);
            choice = scan.nextInt();
            if (choice == 1) {
                AddBookToStore();
            } else if (choice == 2) {
                AddDVDToStore();
            } else if (choice == 3) {
                AddCDToStore();
            } else {
                break;
            }
        }
    }

    private static void AddCDToStore() {
        System.out.println("Input CD's features: ");
        String artist, director, title, category, trackTitle;
        float cost;
        List<Track> tracks = new ArrayList<Track>();
        int trackLength;

        scan = new Scanner(System.in);
        System.out.print("Title: ");
        title = scan.nextLine().toLowerCase().strip();
        System.out.print("Category: ");
        category = scan.nextLine().toLowerCase().strip();
        System.out.print("Cost [Enter a float]: ");
        cost = (float) scan.nextDouble();
        scan = new Scanner(System.in);
        System.out.print("Director: ");
        director = scan.nextLine().toLowerCase().strip();
        System.out.print("Artist: ");
        artist = scan.nextLine().toLowerCase().strip();

        while (true) {
            Track track = addTrack();
            System.out.print("Add this track? Are you sure? [Y/n]: ");
            scan = new Scanner(System.in);
            if (!scan.nextLine().toLowerCase().strip().equals("y")) {
                break;
            }
            tracks.add(track);
            System.out.print("Add more tracks? [Y/n]: ");
            scan = new Scanner(System.in);
            if (!scan.nextLine().toLowerCase().strip().equals("y")) {
                break;
            }
        }
        CompactDisc CD = new CompactDisc(title, category, cost, director, artist, tracks);
        System.out.print("Add this CD? Are you sure? [Y/n]: ");
        if (scan.nextLine().toLowerCase().strip().equals("y")) {
            store.addMedia(CD);
        }
    }

    private static Track addTrack() {
        String trackTitle;
        int trackLength;

        scan = new Scanner(System.in);
        System.out.print("New Track Title: ");
        trackTitle = scan.nextLine().toLowerCase().strip();
        System.out.print("... with length [Enter an integer]: ");
        trackLength = scan.nextInt();
        return new Track(trackTitle, trackLength);
    }

    private static void AddDVDToStore() {
        System.out.println("Input DVD's features: ");
        String title, category, director;
        int length;
        float cost;

        scan = new Scanner(System.in);
        System.out.print("Title: ");
        title = scan.nextLine().toLowerCase().strip();
        System.out.print("Category: ");
        category = scan.nextLine().toLowerCase().strip();
        System.out.print("Cost [Enter a float]: ");
        cost = (float) scan.nextDouble();
        System.out.print("Length [Enter an integer]: ");
        length = scan.nextInt();
        System.out.print("Director: ");
        scan = new Scanner(System.in);
        director = scan.nextLine().toLowerCase().strip();
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, director, length);

        System.out.print("Add this DVD? Are you sure? [Y/n]: ");
        scan = new Scanner(System.in);
        if (scan.nextLine().toLowerCase().strip().equals("y")) {
            store.addMedia(dvd);
        }
    }

    private static void AddBookToStore() {
        System.out.println("Input book's features:");
        String title, category;
        float cost;
        List<String> authors;

        scan = new Scanner(System.in);
        System.out.print("Title: ");
        title = scan.nextLine().toLowerCase().strip();
        System.out.print("Category: ");
        category = scan.nextLine().toLowerCase().strip();
        System.out.print("Cost [Enter a float]: ");
        cost = (float) scan.nextDouble();
        System.out.print("Authors [Separate them by <,>]: ");
        scan = new Scanner(System.in);
        authors = Arrays.asList(scan.nextLine().toLowerCase().strip().split(","));
        Book book = new Book(title, category, cost, authors);

        System.out.print("Add this book? Are you sure? [Y/n]: ");
        if (scan.nextLine().toLowerCase().strip().equals("y")) {
            store.addMedia(book);
        }
    }

    private static void PlaceOrder() {
        if (cart.getItemsOrdered().size() > 0) {
            System.out.println("Order is created.");
            cart.getItemsOrdered().clear();
        }
        else {
            System.out.println("Your cart is empty.");
        }
    }

    private static void RemoveMediaFromCart() {
        while (true) {
            System.out.print("Enter exact media title [0 to exit]: ");

            scan = new Scanner(System.in);
            String title = scan.nextLine().toLowerCase().strip();

            choice = (title.equals("0")) ? 0 : searchCartByTitle(title);
            if (choice == 0) {
                break;
            }
            if (choice == -1) {
                System.out.println("Media title not found.");
            } else {
                choice -= 1;
                Media item = cart.getItemsOrdered().get(choice);
                cart.removeMedia(item);
            }
        }
    }

    private static int searchCartByTitle(String title) {
        int i = 1;
        for (Media e : cart.getItemsOrdered()) {
            if (e.getTitle().equals(title)) {
                return i;
            }
            i += 1;
        }
        // Return -1 if not found
        return -1;
    }

    private static void SortMediaInCart() {
        while (true) {
            System.out.print("Sort by title [1] or cost [2]? [0 to exit] ");

            scan = new Scanner(System.in);
            choice = scan.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice == 1) {
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
            } else if (choice == 2) {
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
            }
            for (Media e : cart.getItemsOrdered()) {
                e.toString();
            }
        }
    }

    private static void FilterMediaInCart() {
        while (true) {
            System.out.print("Filter by id [1] or title [2]? [0 to exit] ");

            scan = new Scanner(System.in);
            choice = scan.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice == 1) {
                System.out.print("Filtering by ID [Enter a positive integer]: ");
                int id = scan.nextInt();
                boolean found = false;
                for (Media e : cart.getItemsOrdered()) {
                    if (e.getId() == id) {
                        e.toString();
                        found = true;
                    }
                }
                if (found == false) {
                    System.out.println("Item not found");
                }
            } else if (choice == 2) {
                System.out.println("Filtering by title [Enter exact title]: ");
                scan = new Scanner(System.in);
                String title = scan.nextLine().toLowerCase();
                boolean found = false;
                for (Media e : cart.getItemsOrdered()) {
                    if (e.getTitle().equals(title)) {
                        e.toString();
                        found = true;
                    }
                }
                if (found == false) {
                    System.out.println("Item not found");
                }
            }
        }
    }

    private static void PlayAMedia() {
        while (true) {
            System.out.print("Enter media title [0 to exit]: ");

            scan = new Scanner(System.in);
            String title = scan.nextLine().toLowerCase().strip();

            choice = (title.equals("0")) ? 0 : searchStoreByTitle(title);
            if (choice == 0) {
                break;
            }
            if (choice == -1) {
                System.out.println("Media title not found.");
            } else {
                choice -= 1; // index in array
                Media item = store.getItemsInStore().get(choice);
                Play(item);
            }
        }
    }

    private static void AddMediaToCart() {
        while (true) {
            System.out.print("Enter exact media title [0 to exit]: ");

            scan = new Scanner(System.in);
            String title = scan.nextLine().toLowerCase().strip();

            choice = (title.equals("0")) ? 0 : searchStoreByTitle(title);
            if (choice == 0) {
                break;
            }
            if (choice == -1) {
                System.out.println("Media title not found.");
            } else {
                choice -= 1; // index in array
                Media item = store.getItemsInStore().get(choice);
                cart.addMedia(item);
            }
        }
    }

    private static void SeeMediaDetails() {
        while (true) {
            System.out.print("Enter exact media title [0 to exit]: ");

            scan = new Scanner(System.in);
            String title = scan.nextLine().toLowerCase().strip();

            choice = (title.equals("0")) ? 0 : searchStoreByTitle(title);
            if (choice == 0) {
                break;
            }
            if (choice == -1) {
                System.out.println("Media title not found.");
            } else {
                choice -= 1; // index in array
                // Add item to cart
                Media item = store.getItemsInStore().get(choice);
                item.toString();

                // Option to play CD or DVD
                if (item instanceof Disc) {
                    System.out.print("Do you want to play it? [Y/n] ");
                    scan = new Scanner(System.in);
                    if (scan.next().toLowerCase().strip().equals("y")) {
                        Play(item);
                    }
                }

                // Option to add current item to cart
                System.out.print("Do you want to add it to cart? [Y/n] ");
                if (scan.next().toLowerCase().strip().equals("y")) {
                    cart.addMedia(item);
                }
            }
            break;
        }
    }

    private static void Play(Media item) {
        if (item instanceof Book) {
            System.out.println("Book can't be played.");
        } else
            ((Disc) item).play();
    }

    private static int searchStoreByTitle(String title) {
        int i = 1;
        for (Media e : store.getItemsInStore()) {
            if (e.getTitle().equals(title)) {
                return i;
            }
            i += 1;
        }
        // return -1 if not found
        return -1;
    }

}
