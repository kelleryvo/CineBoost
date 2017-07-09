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
    public TableView<String> tblFilm;
    public ComboBox dropDatum;

    @FXML
    public void initialize(){

        DbConnection con = new DbConnection();

        ResultSet rs = con.executeQuery("SELECT * FROM Movie AS mo INNER JOIN Offer AS of ON mo.id = of.movie_FK WHERE mo.id = "+Main.movieId+"");
        ObservableList<String> options = FXCollections.observableArrayList();

        try {
            while(rs.next()){

                ObservableList<String> list = FXCollections.observableArrayList();

                list.add(rs.getString("name"));
                list.add(rs.getString("genre"));
                list.add(rs.getString("movieStart"));
                list.add(rs.getString("fsk"));

                String date = rs.getString("movieStart");
                date = date.substring(0, Math.min(date.length(), 10));

                options.add(date);

                TableColumn<String, String> col1 = new TableColumn<>();
                col1.setText("Film");
                col1.setPrefWidth(395);
                TableColumn<String, String> col2 = new TableColumn<>();
                col2.setText("Genre");
                col2.setPrefWidth(244);
                TableColumn<String, String> col3 = new TableColumn<>();
                col3.setText("Datum und Uhrzeit");
                col3.setPrefWidth(290);
                TableColumn<String, String> col4 = new TableColumn<>();
                col4.setText("FSK");
                col4.setPrefWidth(150);
                tblFilm.getColumns().addAll(col1, col2, col3, col4);

                col1.setCellValueFactory(data -> new SimpleStringProperty(list.get(0)));
                col2.setCellValueFactory(data -> new SimpleStringProperty(list.get(1)));
                col3.setCellValueFactory(data -> new SimpleStringProperty(list.get(2)));
                col4.setCellValueFactory(data -> new SimpleStringProperty(list.get(3)));
                tblFilm.setItems(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dropDatum.getItems().add(options);

        tblFilm.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                Main.ticketId = tblFilm.getSelectionModel().getSelectedItem();
            }
        });

        btnSelectTickets.setOnAction((event) -> {

            if (Main.ticketId != "") {
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
