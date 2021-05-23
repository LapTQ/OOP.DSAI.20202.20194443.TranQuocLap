package hust.soict.dsai.aims.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AddDigitalVideoDiscToStoreScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Add DVD");
        stage.setScene(scene);
        stage.show();
    }
}
