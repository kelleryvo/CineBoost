package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.Main;

import java.io.IOException;

/**
 * Created by marcvollenweider on 26.06.17.
 *
 * @param iAdult Wie viele Erwachsene wurden ausgewählt?
 * @param iTeen Wie viele Teenager wurden ausgewählt?
 * @param iChild Wie viele Kinder wurden ausgewählt?
 *
 */
public class AnzahlpersonenCo {
    public int iAdult = 0;
    public int iTeen = 0;
    public int iChild = 0;

    @FXML
    //Alle Components
    public Button btnSelectTickets;

    public Button btnRemoveAdult;
    public Button btnRemoveTeen;
    public Button btnRemoveChild;

    public Button btnAddAdult;
    public Button btnAddTeen;
    public Button btnAddChild;

    public Label lblAdult;
    public Label lblTeen;
    public Label lblChild;

    @FXML
    public void initialize(){
        btnSelectTickets.setOnAction((event) -> {

            if (iAdult == 0 && iChild == 0 && iTeen == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Anzahl ungültig");
                alert.setContentText("Bitte geben Sie die Anzahl von Person an");
                alert.showAndWait();
            }else{
                Main.amount = iAdult + iTeen + iChild;

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../design/sitzlplatz.fxml"));
                } catch (IOException e) {

                }
                Main.changeScene(new Scene(root, 1080, 720));
            }
        });

        btnRemoveAdult.setOnAction((event) -> {
            if(iAdult > 0){
                iAdult--;
                lblAdult.setText(String.valueOf(iAdult));
            }

        });

        btnRemoveTeen.setOnAction((event) -> {
            if(iTeen > 0){
                iTeen--;
                lblTeen.setText(String.valueOf(iTeen));
            }
        });

        btnRemoveChild.setOnAction((event) -> {
            if(iChild > 0){
                iChild--;
                lblChild.setText(String.valueOf(iChild));
            }
        });

        btnAddAdult.setOnAction((event) -> {
            iAdult++;
            lblAdult.setText(String.valueOf(iAdult));
        });

        btnAddTeen.setOnAction((event) -> {
            iTeen++;
            lblTeen.setText(String.valueOf(iTeen));
        });

        btnAddChild.setOnAction((event) -> {
            iChild++;
            lblChild.setText(String.valueOf(iChild));
        });
    }
}
