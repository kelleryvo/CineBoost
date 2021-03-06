package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    public TextField fieldCreditCard;
    public TextField fieldTotal;
    public TableView tblZahlung;
    public TableColumn colPerson;
    public TableColumn colAnzahl;
    public TableColumn colPreis;

    @FXML
    public void initialize(){

        DbConnection con = new DbConnection();

        ResultSet rs = con.executeQuery("SELECT * FROM Visitor");

        Double total = Main.amount*12.5;
        fieldTotal.setText(total.toString());

        try {
            while(rs.next()){
                if (rs.getInt("id") == Main.userid) {
                    ObservableList<String> list = FXCollections.observableArrayList();

                    list.add(rs.getString("name") + " " + rs.getString("surname"));
                    Integer seat = Main.seats.size();
                    list.add(seat.toString());
                    list.add(fieldTotal.getText());

                    colPerson.setCellValueFactory(data -> new SimpleStringProperty(list.get(0)));
                    colAnzahl.setCellValueFactory(data -> new SimpleStringProperty(list.get(1)));
                    colPreis.setCellValueFactory(data -> new SimpleStringProperty(list.get(2)));
                    tblZahlung.setItems(list);
                }
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

            DbConnection conn = new DbConnection();

            for (String seat : Main.seats) {

                ResultSet rs2 = conn.executeQuery("Select id from Seat where seatName='" + seat + "'");

                String query = null;
                try {
                    rs2.next();
                    query = "INSERT INTO tickets (visitor_fk, offer_fk, seat_fk) " +
                            "VALUES (" + Main.userid + ", " + Main.ticketId + ", " + rs2.getString("id") + ")";
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    conn.getStmt().execute(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            String query2 = "INSERT INTO reservation (ticket_fk) " +
                    "VALUES (" + Main.ticketId + ")";
            try {
                conn.getStmt().execute(query2);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.exit(0);
        });
    }
}
