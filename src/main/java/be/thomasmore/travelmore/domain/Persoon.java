package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Persoon")
@NamedQueries(
        {
                @NamedQuery(
                        name = Persoon.FIND_ALL,
                        query = "SELECT l FROM Persoon l"
                )
        }
)
public class Persoon {
    public static final String FIND_ALL = "Persoon.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "voornaam")
    private String voornaam;
    @Column(name = "naam")
    private String naam;
    @Column(name = "adres")
    private String adres;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @Column(name = "functie")
    private int functie;
    @OneToMany(mappedBy = "persoon")
    private List<Boeking> boekingen = new ArrayList<>();
    @ManyToMany(mappedBy = "personen")
    private List<Betaalmethode> betaalmethodes = new ArrayList<>();

    public Persoon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public int getFunctie() {
        return functie;
    }

    public void setFunctie(int functie) {
        this.functie = functie;
    }

    public List<Boeking> getBoekingen() {
        return boekingen;
    }

    public void setBoekingen(List<Boeking> boekingen) {
        this.boekingen = boekingen;
    }

    public List<Betaalmethode> getBetaalmethodes() {
        return betaalmethodes;
    }

    public void setBetaalmethodes(List<Betaalmethode> betaalmethodes) {
        this.betaalmethodes = betaalmethodes;
    }
}