/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Milica
 */
public class Kompanija implements Serializable {
    private int kompanijaID;
    private String naziv;
    private String maticniBroj;
    private String ulica;
    private String broj;
    private Mesto mesto;

    public Kompanija() {
    }

    public Kompanija(String naziv, String maticniBroj, String ulica, String broj, Mesto mesto) {
        this.naziv = naziv;
        this.maticniBroj = maticniBroj;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }

    public int getKompanijaID() {
        return kompanijaID;
    }

    public void setKompanijaID(int kompanijaID) {
        this.kompanijaID = kompanijaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return naziv + " - " + maticniBroj;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kompanija other = (Kompanija) obj;
        if (this.kompanijaID != other.kompanijaID) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.maticniBroj, other.maticniBroj)) {
            return false;
        }
        return true;
    }
    
    
}
