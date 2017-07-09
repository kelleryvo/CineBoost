package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;
    public static int movieId;
    public static String ticketId = "";
    public static int amount = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader .load(getClass().getResource("design/main.fxml"));

        stage = primaryStage;

        stage.setTitle("CineBoost");
        stage.setScene(new Scene(root, 1080, 720));
        stage.show();
    }

    public static void changeScene(Scene scene){
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}