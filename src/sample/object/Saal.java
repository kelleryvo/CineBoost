package sample.object;

import java.util.ArrayList;

/**
 * Created by yvokeller on 26.06.17.
 */
public class Saal {
    //Attribute
    private int saalnummer;
    private ArrayList<Sitzplatz> sitzplaetze = new ArrayList<>();

    //Constructor
    public Saal(int saalnummer, ArrayList<Sitzplatz> sitzplaetze){
        this.saalnummer = saalnummer;
        this.sitzplaetze = sitzplaetze;
    }

    public int getSaalnummer() {
        return saalnummer;
    }

    public void setSaalnummer(int saalnummer) {
        this.saalnummer = saalnummer;
    }

    public ArrayList<Sitzplatz> getSitzplaetze() {
        return sitzplaetze;
    }

    public void addSitzplatz(ArrayList<Sitzplatz> sitzplaetze) {
        this.sitzplaetze = sitzplaetze;
    }
}
