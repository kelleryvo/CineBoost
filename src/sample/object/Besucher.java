package sample.object;

/**
 * Created by yvokeller on 26.06.17.
 *
 * @param id ID von Kunde
 * @param name Nachname von Kunde
 * @param vorname Vorname von Kunde
 * @param wohnort Wohnort von Kunde
 * @param email E-Mail von Kunde
 * @param username Benutzername von Kunde
 * @param password Passwort von Kunde
 *
 */
public class Besucher {
    //Attribute
    private int id;

    private String name;
    private String vorname;
    private String wohnort;

    private String email;
    private String username;
    private String password;

    //GET & SET

    //Constructor
    public Besucher(int id, String name, String vorname, String wohnort, String email, String username, String password) {
        this.id = id;
        this.name = name;
        this.vorname = vorname;
        this.wohnort = wohnort;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}