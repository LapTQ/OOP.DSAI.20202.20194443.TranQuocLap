package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CartScreenController {

    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label lblTotalCost;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private MenuItem menuViewStore;

    public CartScreenController(Cart cart) {

        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems((ObservableList<Media>) this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        lblTotalCost.setText(totalCost() + "$");
        lblTotalCost.setVisible(true);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {

                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilterMedia(newValue);
            }
        });
    }

    private float totalCost() {
        float s = 0;
        for (Media m: cart.getItemsOrdered()) {
            s += m.getCost();
        }

        return s;
    }

    private void showFilterMedia(String newValue) {
        FilteredList<Media> filteredMedia = new FilteredList<Media>(this.cart.getItemsOrdered());
        String key = newValue.toLowerCase().strip();
        filteredMedia.setPredicate(media -> {
            return ((radioBtnFilterId.isSelected() && Integer.toString(media.getId()).contains(key)) ||
                    (radioBtnFilterTitle.isSelected() && media.getTitle().contains(key)));
        });
        tblMedia.setItems(filteredMedia);
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent e) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        lblTotalCost.setText(totalCost() + "");
    }

    @FXML
    void btnPlayPressed(ActionEvent e) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            String msg = ((Disc) media).play();
            JOptionPane.showMessageDialog(null, msg, "Play", JOptionPane.PLAIN_MESSAGE);
        } catch (PlayerException exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "Illegal Length", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent e) {
        String msg;
        if (cart.getItemsOrdered().size() == 0) {
            msg = "No item in cart";
        }
        else {
            msg = "Thank you for buying!";
        }
        cart.getItemsOrdered().clear();
        new Thread() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, msg, "Place order", JOptionPane.INFORMATION_MESSAGE);
            }
        }.start();

    }

    @FXML
    void menuViewStorePressed(ActionEvent e) {

    }
}
