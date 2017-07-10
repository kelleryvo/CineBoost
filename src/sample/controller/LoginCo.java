package sample.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
 */
public class LoginCo {
    @FXML
    //Alle Components
    public Button btnLogin;
    public TextField fieldUsername;
    public PasswordField fieldPassword;
    public int id = 0;

    @FXML
    public void initialize(){
        
        btnLogin.setOnAction((event) -> {

            Boolean go = false;

            String user = fieldUsername.getText();
            String pw = fieldPassword.getText();

            DbConnection con = new DbConnection();

            ResultSet rs = con.executeQuery("SELECT * FROM Visitor");

            try {
                while(rs.next()){
                    String nameT = rs.getString("name");
                    String pwT = rs.getString("password");
                    if (user.equals(nameT) && pw.equals(pwT)){
                        go = true;
                        id = rs.getInt("id");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (go){
                Main.userid = id;
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../design/payment.fxml"));
                } catch (IOException e) {

                }
                Main.changeScene(new Scene(root, 1080, 720));
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Username/Passwort ist falsch");
                alert.setContentText("Bitte fühlen Sie alle Felder richtig aus. Dann können Sie fortfahren.");
                alert.showAndWait();
            }
        });
    }
}
