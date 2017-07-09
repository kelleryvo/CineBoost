package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import sample.Main;

import java.io.IOException;
import java.util.*;

/**
 * Created by marcvollenweider on 26.06.17.
 */
public class SitzlplatzCo {
    @FXML
    //Alle Components
    public Button btnSelectTickets;
    public Button btnA1, btnA2, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9, btnA10;
    public Button btnB1, btnB2, btnB3, btnB4, btnB5, btnB6, btnB7, btnB8, btnB9, btnB10;
    public Button btnC1, btnC2, btnC3, btnC4, btnC5, btnC6, btnC7, btnC8, btnC9, btnC10;
    public Button btnD1, btnD2, btnD3, btnD4, btnD5, btnD6, btnD7, btnD8, btnD9, btnD10;
    public Integer num = Main.amount;
    public Label amount;

    @FXML
    public void initialize(){
        List<Button> buttons = Arrays.asList(
                btnA1, btnA2, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9, btnA10,
                btnB1, btnB2, btnB3, btnB4, btnB5, btnB6, btnB7, btnB8, btnB9, btnB10,
                btnC1, btnC2, btnC3, btnC4, btnC5, btnC6, btnC7, btnC8, btnC9, btnC10,
                btnD1, btnD2, btnD3, btnD4, btnD5, btnD6, btnD7, btnD8, btnD9, btnD10
        );

        amount.setText("Noch " + num.toString() + " Sitzplätze offen");

        for (Button buttoni : buttons){
            buttoni.setStyle("-fx-background-color: #FFF");
            buttoni.setOnAction((event) -> {
                if (buttoni.getStyle() == "-fx-background-color: #1976D2") {
                    buttoni.setStyle("-fx-background-color: #FFF");
                    num = num + 1;
                    amount.setText("Noch " + num.toString() + " Sitzplätze offen");
                } else {
                    if (num != 0) {
                        buttoni.setStyle("-fx-background-color: #1976D2");
                        num = num - 1;
                        amount.setText("Noch " + num.toString() + " Sitzplätze offen");
                    }
                }
            });
        }

        btnSelectTickets.setOnAction((event) -> {

            if (num == 0) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../design/login.fxml"));
                } catch (IOException e) {

                }
                Main.changeScene(new Scene(root, 1080, 720));
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Es fehlen noch " + num + " Sitzplätze");
                alert.setContentText("Bitte wählen Sie noch " + num + " Sitzplätze aus.");
                alert.showAndWait();
            }
        });
    }
}
