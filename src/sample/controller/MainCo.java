package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import sample.DbConnection;
import sample.Main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by marcvollenweider on 26.06.17.
 */
public class MainCo {
    @FXML
    //Alle Components
    public AnchorPane anchorPane;
    public GridPane gridPane;

    @FXML
    public void initialize(){
        int i = 0;
        DbConnection con = new DbConnection();

        ResultSet rs = con.executeQuery("SELECT * FROM Movie");

        try {
            while(rs.next()){
                i++;
                Image image = new Image(getClass().getResourceAsStream("../MoviePoster/"+rs.getString("id")+".jpg"), 580, 580, true ,true);
                Button btn = new Button();
                btn.setGraphic(new ImageView(image));
                btn.setMaxHeight(gridPane.getHeight());

                int id = rs.getInt("id");

                btn.setOnAction((event) -> {

                    Main.movieId = id;
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("../design/filminfos.fxml"));
                    } catch (IOException e) {

                    }
                    Main.changeScene(new Scene(root, 1080, 720));
                });

                gridPane.add(btn, i, 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
