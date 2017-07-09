package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.DbConnection;
import sample.Main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by marcvollenweider on 26.06.17.
 *
 */
public class FilminfosCo {
    @FXML
    //Alle Components
    public Button btnSelectTickets;
    public TextField fieldName;
    public TextField fieldGenre;
    public TextField fieldFSK;
    public TextField fieldSpieldauer;
    public TextField fieldBewertung;
    public TextField fieldKinostart;
    public TextField fieldRegie;
    public TextField fieldDarsteller;
    public ImageView imgCover;

    @FXML
    public void initialize(){

        DbConnection con = new DbConnection();

        ResultSet rs = con.executeQuery("SELECT * FROM Movie WHERE id = "+Main.movieId+"");

        try {
            while(rs.next()){
                fieldName.setText(rs.getString("name"));
                fieldGenre.setText(rs.getString("genre"));
                fieldFSK.setText(rs.getString("fsk"));
                fieldSpieldauer.setText(rs.getString("duration"));
                fieldBewertung.setText(rs.getString("movieRating"));
                fieldKinostart.setText(rs.getString("productionsYear"));
                fieldRegie.setText(rs.getString("director"));
                fieldDarsteller.setText(rs.getString("actor"));

                Image image = new Image(getClass().getResourceAsStream("../MoviePoster/"+rs.getString("id")+".jpg"), 580, 580, true ,true);
                imgCover.setImage(image);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        btnSelectTickets.setOnAction((event) -> {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../design/ticketauswahl.fxml"));
            } catch (IOException e) {

            }
            Main.changeScene(new Scene(root, 1080, 720));
        });
    }
}
