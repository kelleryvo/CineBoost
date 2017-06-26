package sample;

import sample.object.Film;

import java.sql.*;
import java.util.ArrayList;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Nico Lutz on 26.06.2017.
 */
public class DbConnection {

    private Connection conn;
    private Statement stmt;

    public DbConnection(String database, String user, String password) {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?user=" + user + "&password=" + password);
            this.stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public Statement getStmt() {
        return stmt;
    }

    public Connection getConn() {
        return conn;
    }

    /*public void setConn(String database, String user, String password) {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?user=" + user + "&password=" + password);
            this.stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public ResultSet executeSelect(String query){
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return rs;
    }
}