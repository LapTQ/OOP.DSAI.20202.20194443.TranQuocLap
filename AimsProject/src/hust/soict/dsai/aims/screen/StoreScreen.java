package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import hust.soict.dsai.aims.store.Store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.UIManager;


public class StoreScreen extends JFrame {

    public static Store store;
    public static Cart cart = new Cart();
    public static JPanel center;
    public static AddBookToStoreScreen addBookToStore = new AddBookToStoreScreen();
    public static AddCDToStoreScreen addCDToStore = new AddCDToStoreScreen();
    public static AddDigitalVideoDiscToStoreScreen addDVDToStore = new AddDigitalVideoDiscToStoreScreen();



    JPanel createNorth() {

        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        addBookMenuItem.addActionListener(new buttonListener());
        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        addCDMenuItem.addActionListener(new buttonListener());
        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
        addDVDMenuItem.addActionListener(new buttonListener());
        smUpdateStore.add(addBookMenuItem);
        smUpdateStore.add(addCDMenuItem);
        smUpdateStore.add(addDVDMenuItem);

        menu.add(smUpdateStore);
//        menu.add(new JMenuItem("View store"));
//        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.decode("#3700b3"));

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        cart.addActionListener(new buttonListener());

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    public class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String button = event.getActionCommand();
            if (button.equals("View cart")) {
                new CartScreen(cart);
            }
            else {
                if (button.equals("Add Book")) {
                    new Thread() {
                        @Override
                        public void run() {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        addBookToStore.start(new Stage());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }.start();
                }
                else if (button.equals("Add CD")) {
                    new Thread() {
                        @Override
                        public void run() {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        addCDToStore.start(new Stage());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }.start();
                }
                else if (button.equals("Add DVD")) {
                    new Thread() {
                        @Override
                        public void run() {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        addDVDToStore.start(new Stage());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }.start();
                }

                SwingUtilities.invokeLater(updateUI);
            }
        }
    }

    Runnable updateUI = new Runnable() {
        @Override
        public void run() {
            int nMedia = store.getItemsInStore().size();
            if (center.getComponentCount() < nMedia) {
                center.add(new MediaStore(store.getItemsInStore().get(nMedia - 1)));
                center.updateUI();
            }
        }
    };

    JPanel createCenter() {

        center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i ++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            System.out.println("Look and feel not set");
        }

        JFXPanel fxPanel = new JFXPanel();
        Platform.setImplicitExit(false);

        new StoreScreen(new Store());
    }

}
