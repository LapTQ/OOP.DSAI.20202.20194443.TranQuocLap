package hust.soict.dsai.aims.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddBookToStoreScreen extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AddBookToStoreScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Add Book");
        stage.setScene(scene);
        stage.show();
    }
}
