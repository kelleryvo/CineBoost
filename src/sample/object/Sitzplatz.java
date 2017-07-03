package sample.object;

/**
 * Created by yvokeller on 26.06.17.
 *
 * @param sitznummer Nummer vom Sitzplatz z.B. 1A
 * @param status Verfügbarkeit
 * @return sitznummer Rückgabewert für Anforgerung von Sitznummer
 * @return status Rückgabewert für Anforgerung von Verfügbarkeit
 *
 */
public class Sitzplatz {
    //Attribute
    private int sitznummer;
    private boolean status;

    //GET & SET
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSitznummer() {
        return sitznummer;
    }

    public void setSitznummer(int sitznummer) {
        this.sitznummer = sitznummer;
    }

    //Constructor
    public Sitzplatz(int sitznummer, boolean status){
        this.sitznummer = sitznummer;
        this.status = status;
    }
}