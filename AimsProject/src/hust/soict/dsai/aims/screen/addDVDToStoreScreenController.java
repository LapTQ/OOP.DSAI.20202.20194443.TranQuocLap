package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.DuplicateException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;

public class addDVDToStoreScreenController {

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfLength;

    @FXML
    private Button btnAdd;

    @FXML
    void btnAddPressed(ActionEvent event) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()), Integer.parseInt(tfLength.getText()));
        try {
            StoreScreen.store.addMedia(dvd);
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
