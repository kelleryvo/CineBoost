package sample.object;

/**
 * Created by denni on 26.06.2017.
 *
 * @param produktionsjahr Produktionsjahr von Film
 * @param filmbeschreibung Beschreibung von Film
 * @param genre Genre von Film
 * @param fsk Altersfreigabe von Film
 * @param filmdauer Dauer von Film
 * @param filmbewertung Bewertung von Film
 * @param kinostartKinostart von Film
 * @param regisseur Regisseur von Film
 * @param darsteller Darsteller von Film
 * @return produktionsjahr Rückgabewert für Anforgerung von Produktionsjahr
 * @return filmbeschreibung Rückgabewert für Anforgerung von Filmbeschreibung
 * @return genre Rückgabewert für Anforgerung von Genre
 * @return fsk Rückgabewert für Anforgerung von Altersfreigabe FSK
 * @return filmdauer Rückgabewert für Anforgerung von Filmdauer
 * @return filmbewertung Rückgabewert für Anforgerung von Filmbewertung
 * @return kinostart Rückgabewert für Anforgerung von Kinostart
 * @return regie Rückgabewert für Anforgerung von Regie
 * @return darsteller Rückgabewert für Anforgerung von Darsteller
 *
 */
public class Film {
    //Variablen
    private int produktionsjahr;
    private String filmbeschreibung;
    private String genre;
    private int fsk;
    private String filmdauer;
    private String filmbewertung;
    private String kinostart;
    private String regie;
    private String darsteller;

    public Film(int produktionsjahr, String filmbeschreibung, String genre, int fsk, String filmdauer, String filmbewertung, String kinostart, String regie, String darsteller) {
        this.produktionsjahr = produktionsjahr;
        this.filmbeschreibung = filmbeschreibung;
        this.genre = genre;
        this.fsk = fsk;
        this.filmdauer = filmdauer;
        this.filmbewertung = filmbewertung;
        this.kinostart = kinostart;
        this.regie = regie;
        this.darsteller = darsteller;
    }

    public int getProduktionsjahr() {
        return produktionsjahr;
    }

    public void setProduktionsjahr(int produktionsjahr) {
        this.produktionsjahr = produktionsjahr;
    }

    public String getFilmbeschreibung() {
        return filmbeschreibung;
    }

    public void setFilmbeschreibung(String filmbeschreibung) {
        this.filmbeschreibung = filmbeschreibung;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getFsk() {
        return fsk;
    }

    public void setFsk(int fsk) {
        this.fsk = fsk;
    }

    public String getFilmdauer() {
        return filmdauer;
    }

    public void setFilmdauer(String filmdauer) {
        this.filmdauer = filmdauer;
    }

    public String getFilmbewertung() {
        return filmbewertung;
    }

    public void setFilmbewertung(String filmbewertung) {
        this.filmbewertung = filmbewertung;
    }

    public String getKinostart() {
        return kinostart;
    }

    public void setKinostart(String kinostart) {
        this.kinostart = kinostart;
    }

    public String getRegie() {
        return regie;
    }

    public void setRegie(String regie) {
        this.regie = regie;
    }

    public String getDarsteller() {
        return darsteller;
    }

    public void setDarsteller(String darsteller) {
        this.darsteller = darsteller;
    }

    //Funktionen
    public void Update(){

    }

    public void SetInformation(){

    }

    public void Bewertungerhalten(){

    }

    public void DeleteMovie(){

    }
}
