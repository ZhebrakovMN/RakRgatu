package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Создание простейшей визуальной программы на Java");
        primaryStage.setScene(new Scene(root, 600, 283));
        primaryStage.setOnCloseRequest(Event::consume);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
