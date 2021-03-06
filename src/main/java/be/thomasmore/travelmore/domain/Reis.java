package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "SELECT r FROM Reis r"
                ),
                @NamedQuery(
                        name = Reis.ZOEK_REIZEN,
                        query = "SELECT r FROM Reis r where r.vertrekDatum = :vertrekDatum"
                )
        }
)
public class Reis {
    public static final String FIND_ALL = "Reis.findAll";
    public static final String ZOEK_REIZEN = "Reis.zoekReizen";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "vertrekDatum")
    private Date vertrekDatum;
    @Column(name = "aankomstDatum")
    private Date aankomstDatum;
    @ManyToOne
    private Locatie vertrekLocatie = new Locatie();
    @ManyToOne
    private Locatie aankomstLocatie = new Locatie();
    @ManyToOne
    private Transportmiddel transportmiddel = new Transportmiddel();
    @OneToMany(mappedBy = "reis")
    private List<Boeking> boekingreis = new ArrayList<>();
    @Column(name = "prijs")
    private float prijs;
    @Column(name = "aantalPlaatsen")
    private int aantalPlaatsen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reis() {
    }

    public Reis(Date vertrekdatum, Date aankomstdatum) {
        this.id = 0;

        vertrekDatum = vertrekdatum;
        aankomstDatum = aankomstdatum;
        Locatie tempVertrekLoc = new Locatie();
        Locatie tempAankomstLoc = new Locatie();
        tempVertrekLoc.setId(0);
        tempAankomstLoc.setId(0);
        this.setVertrekLocatie(tempVertrekLoc);
        this.setAankomstLocatie(tempAankomstLoc);

        Transportmiddel tempTrans = new Transportmiddel();
        tempTrans.setId(0);
        this.setTransportmiddel(tempTrans);
    }

    public Date getVertrekDatum() {
        return vertrekDatum;
    }

    public void setVertrekDatum(Date vertrekDatum) {
        this.vertrekDatum = vertrekDatum;
    }

    public Date getAankomstDatum() {
        return aankomstDatum;
    }

    public void setAankomstDatum(Date aankomstDatum) {
        this.aankomstDatum = aankomstDatum;
    }

    public Locatie getVertrekLocatie() {
        return vertrekLocatie;
    }

    public void setVertrekLocatie(Locatie vertrekLocatie) {
        this.vertrekLocatie = vertrekLocatie;
    }

    public Locatie getAankomstLocatie() {
        return aankomstLocatie;
    }

    public void setAankomstLocatie(Locatie aankomstLocatie) {
        this.aankomstLocatie = aankomstLocatie;
    }

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public List<Boeking> getBoekingreis() {
        return boekingreis;
    }

    public void setBoekingreis(List<Boeking> boekingreis) {
        this.boekingreis = boekingreis;
    }
}
