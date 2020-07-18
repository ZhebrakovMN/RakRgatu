package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Сложные табличные вычисления в Java");
        primaryStage.setScene(new Scene(root, 710, 295));
        primaryStage.setOnCloseRequest(Event::consume);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
