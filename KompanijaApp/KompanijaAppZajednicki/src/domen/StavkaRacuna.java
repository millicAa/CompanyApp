/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Milica
 */
public class StavkaRacuna implements Serializable {

    private int rb;
    private int kolicina;
    private double iznos;
    private Proizvod proizvod;
    private JedinicaMere jedinicaMere;

    public StavkaRacuna() {
        this.proizvod = new Proizvod();
    }

    public StavkaRacuna(int rb, int kolicina, double iznos, Proizvod proizvod, JedinicaMere jedinicaMere) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.proizvod = proizvod;
        this.jedinicaMere = jedinicaMere;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }
}
