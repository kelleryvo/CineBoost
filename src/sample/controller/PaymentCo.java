package sample.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.DbConnection;
import sample.Main;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by marcvollenweider on 26.06.17.
 */
public class PaymentCo {
    @FXML
    //Alle Components
    public Button btnLogin;
    public Button btnÄndern;
    public TextField fieldMovie;
    public TextField fieldCreditCard;
    public TextField fieldTotal;
    public TableView tblZahlung;
    public TableColumn colPerson;
    public TableColumn colAnzahl;
    public TableColumn colPreis;

    @FXML
    public void initialize(){

        DbConnection con = new DbConnection();

        ResultSet rs = con.executeQuery("SELECT * FROM Movie WHERE '"+Main.movieId+"'");

        try {
            while(rs.next()){
                fieldMovie.setText(rs.getString("name"));
                Double total = Main.amount*12.50;
                fieldTotal.setText(total.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        fieldCreditCard.setText("Kreditkarte fehlt");

        btnÄndern.setOnAction((event) -> {

            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            VBox dialogVbox = new VBox(20);
            Label creditnamtext = new Label("Inhaber (Vorname/Nachname): ");
            TextField creditnam = new TextField();
            Label creditnumtext = new Label("Kreditkartennummer: ");
            TextField creditnum = new TextField();
            Label creditdattext = new Label("Ablaufdatum: ");
            TextField creditdat = new TextField();
            Label creditcodtext = new Label("Sicherheitscode: ");
            TextField creditcod = new TextField();

            Button but = new Button("Save");
            but.setOnAction(e -> {
                if (!creditnam.equals("") && !creditnum.equals("") && !creditdat.equals("") && !creditcod.equals("")){
                    dialog.hide();
                    fieldCreditCard.setText("Kreditkarte verfügbar");
                }
            });

            dialogVbox.getChildren().addAll(creditnamtext, creditnam, creditnumtext, creditnum, creditdattext, creditdat, creditcodtext, creditcod, but);
            Scene dialogScene = new Scene(dialogVbox, 300, 400);
            dialog.setScene(dialogScene);
            dialog.show();
        });

        btnLogin.setOnAction((event) -> {

            System.exit(0);
        });
    }
}
