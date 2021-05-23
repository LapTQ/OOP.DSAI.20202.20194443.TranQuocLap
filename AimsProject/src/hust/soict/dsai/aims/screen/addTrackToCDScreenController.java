package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.DuplicateException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class addTrackToCDScreenController {

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfLength;

    @FXML
    private Button btnAdd;

    @FXML
    void btnAddPressed(ActionEvent event) {
        Track track = new Track(tfTitle.getText(), Integer.parseInt(tfLength.getText()));
        try {
            addCDToStoreScreenController.CD.addTrack(track);
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
