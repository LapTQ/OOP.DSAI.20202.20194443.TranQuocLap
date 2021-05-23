package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class addBookToStoreScreenController {

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private Button btnAdd;

    @FXML
    void btnAddPressed(ActionEvent event) {
        Book book = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
        try {
            StoreScreen.store.addMedia(book);
            Stage stage = (Stage) btnAdd.getScene().getWindow();
            stage.close();
        } catch (DuplicateException e) {
            e.printStackTrace();
            new Thread() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Duplicate Media", JOptionPane.ERROR_MESSAGE);
                }
            }.start();
        }

    }
}
