package sample.object;

/**
 * Created by yvokeller on 26.06.17.
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