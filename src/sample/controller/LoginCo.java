package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DbConnection;
import sample.Main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by marcvollenweider on 26.06.17.
 */
public class LoginCo {
    @FXML
    //Alle Components
    public Button btnLogin;
    public TextField fieldUsername;
    public TextField fieldPassword;

    @FXML
    public void initialize(){
        String user = fieldUsername.getText();
        String pw = fieldPassword.getText();
        
        btnLogin.setOnAction((event) -> {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../design/payment.fxml"));
            } catch (IOException e) {

            }
            Main.changeScene(new Scene(root, 1080, 720));
        });
    }
}
