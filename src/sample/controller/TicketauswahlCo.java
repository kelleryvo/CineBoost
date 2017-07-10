package sample.controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.DbConnection;
import sample.Main;
import sample.object.Angebot;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by marcvollenweider on 26.06.17.
 */
public class TicketauswahlCo {
    @FXML
    //Alle Components
    public Button btnSelectTickets;
    public TableView<Angebot> tblFilm;
    public ComboBox dropDatum;

    @FXML
    public void initialize(){

        DbConnection con = new DbConnection();

        ResultSet rs = con.executeQuery("SELECT * FROM Movie AS mo INNER JOIN Offer AS of ON mo.id = of.movie_FK WHERE mo.id = "+Main.movieId+"");
        ObservableList<String> options = FXCollections.observableArrayList();
        ObservableList<Angebot> angebots = FXCollections.observableArrayList();

        try {
            while(rs.next()){
                Angebot angebot = new Angebot(rs.getInt("id"), rs.getString("movieStart"), "", rs.getString("name"), rs.getString("genre"), rs.getString("fsk"), "");

                String date = rs.getString("movieStart");
                date = date.substring(0, Math.min(date.length(), 10));

                options.add(date);

                TableColumn col1 = new TableColumn<>();
                col1.setText("Film");
                col1.setPrefWidth(395);
                TableColumn col2 = new TableColumn<>();
                col2.setText("Genre");
                col2.setPrefWidth(244);
                TableColumn col3 = new TableColumn<>();
                col3.setText("Datum und Uhrzeit");
                col3.setPrefWidth(290);
                TableColumn col4 = new TableColumn<>();
                col4.setText("FSK");
                col4.setPrefWidth(150);
                tblFilm.getColumns().addAll(col1, col2, col3, col4);

                col1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Angebot, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Angebot, String> c) {
                        return new SimpleStringProperty(c.getValue().getFilm());
                    }
                });
                col2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Angebot, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Angebot, String> c) {
                        return new SimpleStringProperty(c.getValue().getSprache());
                    }
                });
                col3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Angebot, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Angebot, String> c) {
                        return new SimpleStringProperty(c.getValue().getDatum());
                    }
                });
                col4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Angebot, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Angebot, String> c) {
                        return new SimpleStringProperty(c.getValue().getDimension());
                    }
                });

                angebots.add(angebot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblFilm.setItems(angebots);

        dropDatum.getItems().add(options);

        tblFilm.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                Main.ticketId = tblFilm.getSelectionModel().getSelectedItem().getId();
            }
        });

        btnSelectTickets.setOnAction((event) -> {

            if (Main.ticketId != 0) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../design/anzahlpersonen.fxml"));
                } catch (IOException e) {

                }
                Main.changeScene(new Scene(root, 1080, 720));
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Angebot nicht ausgewählt");
                alert.setContentText("Bitte wählen Sie ein Angebot aus.");
                alert.showAndWait();
            }
        });
    }
}
