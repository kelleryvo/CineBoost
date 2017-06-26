package sample.object;

import java.util.Date;

/**
 * Created by yvokeller on 26.06.17.
 */
public class Ticket {
    //Attribute
    private int id;
    private int saalnummer;
    private final int sitznummer;
    private int sitzplatznummer;

    private Date begin;

    private Film film;
    private Besucher owner;

    //GET & SET

    //Constructor
    public Ticket(int id, int saalnummer, int sitznummer, Date begin, Film film, Besucher owner) {
        this.id = id;
        this.saalnummer = saalnummer;
        this.sitznummer = sitznummer;
        this.begin = begin;
        this.film = film;
        this.owner = owner;
    }
}
