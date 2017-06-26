package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import sample.Main;

import java.io.IOException;

/**
 * Created by marcvollenweider on 26.06.17.
 */
public class SitzlplatzCo {
    @FXML
    //Alle Components
    public Button btnSelectTickets;

    @FXML
    public void initialize(){
        btnSelectTickets.setOnAction((event) -> {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../design/login.fxml"));
            } catch (IOException e) {

            }
            Main.changeScene(new Scene(root, 1080, 720));
        });
    }
}
