package sample.object;

/**
 * Created by denni on 26.06.2017.
 */
public class Angebot {
    private String datum;
    private String zeit;
    private String film;
    private String sprache;
    private String dimension;
    private String saal;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getZeit() {
        return zeit;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getSaal() {
        return saal;
    }

    public void setSaal(String saal) {
        this.saal = saal;
    }

    public Angebot(String datum, String zeit, String film, String sprache, String dimension, String saal) {
        this.datum = datum;
        this.zeit = zeit;
        this.film = film;
        this.sprache = sprache;
        this.dimension = dimension;
        this.saal = saal;
    }
}
