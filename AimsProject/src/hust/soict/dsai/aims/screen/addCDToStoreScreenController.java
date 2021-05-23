package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.DuplicateException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class addCDToStoreScreenController {

    public static CompactDisc CD;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private Button btnAdd;

    @FXML
    private TableView<Track> tblTrack;

    @FXML
    private TableColumn<Track, String> colTrackTitle;

    @FXML
    private TableColumn<Track, String> ColTrackLength;

    @FXML
    private Button btnAddTrack;

    @FXML
    private Button btnRemoveTrack;

    @FXML
    private void initialize() {
        CD = new CompactDisc();
        colTrackTitle.setCellValueFactory(new PropertyValueFactory<Track, String>("title"));
        ColTrackLength.setCellValueFactory(new PropertyValueFactory<Track, String>("length"));
        tblTrack.setItems(CD.tracks);

        btnRemoveTrack.setVisible(false);
        tblTrack.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Track>() {
                    @Override
                    public void changed(ObservableValue<? extends Track> observableValue, Track oldValue, Track newValue) {
                        if (newValue != null) {
                            btnRemoveTrack.setVisible(true);
                        }
                    }
                }
        );
    }

    @FXML
    void btnAddTrackPressed(ActionEvent event) {
        new Thread() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new AddTrackToCDScreen().start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        }.start();
    }

    @FXML
    void btnAddPressed(ActionEvent event) {
        CD.setTitle(tfTitle.getText());
        CD.setCategory(tfCategory.getText());
        CD.setCost(Float.parseFloat(tfCost.getText()));
        try {
            StoreScreen.store.addMedia(CD);
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

    @FXML
    void btnRemoveTrackPressed(ActionEvent event) {
        int i = tblTrack.getSelectionModel().getSelectedIndex();
        CD.tracks.remove(i);
    }
}
