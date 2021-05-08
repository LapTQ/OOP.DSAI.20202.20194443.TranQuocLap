package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MyGUI.fxml"));
        primaryStage.setTitle("When should I pop the question?");
        primaryStage.setScene(new Scene(root, 400, 90));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
