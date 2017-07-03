package sample.object;

/**
 * Created by denni on 26.06.2017.
 *
 * @param datum Angabe zum Tag, an dem Film läuft
 * @param zeit Angabe, um welche Zeit Film läuft
 * @param film Name des Films
 * @param sprache Sprache des Films
 * @param dimension Angabe zur Dimension des Films -> 3D+4D
 * @param saal Angabe zum Saal
 * @return datum Rückgabewert für Anforgerung von Datum
 * @return zeit Rückgabewert für Anforgerung von Zeit
 * @return film Rückgabewert für Anforgerung von Film
 * @return sprache Rückgabewert für Anforgerung von Sprache
 * @return dimension Rückgabewert für Anforgerung von Dimension
 * @return saal Rückgabewert für Anforgerung von Saal
 *
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
