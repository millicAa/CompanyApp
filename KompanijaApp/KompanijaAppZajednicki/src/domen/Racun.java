/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Milica
 */
public class Racun implements Serializable {

    private int racunID;
    private Date datum;
    private double ukupanIznos;
    private Kompanija kompanija;
    private List<StavkaRacuna> stavkaList;

    public Racun() {
        stavkaList = new ArrayList<>();
    }

    public Racun(int racunID, Date datum, double ukupanIznos, Kompanija kompanija) {
        this.racunID = racunID;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.kompanija = kompanija;
        this.stavkaList = new ArrayList<>();
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    public List<StavkaRacuna> getStavkaList() {
        return stavkaList;
    }

    public void setStavkaList(List<StavkaRacuna> stavkaList) {
        this.stavkaList = stavkaList;
    }

    public void dodajStavku() {
        stavkaList.add(new StavkaRacuna());
    }

    public void obrisiStavku(int red) {
        stavkaList.remove(red);
    }

    public void pripremiRacun() {
        double ukupanIznos = 0;
        int rb = 0;
        for (StavkaRacuna stavka : getStavkaList()) {
            ukupanIznos += stavka.getIznos();
            rb++;
            stavka.setRb(rb);
        }
        setUkupanIznos(ukupanIznos);
    }
}
