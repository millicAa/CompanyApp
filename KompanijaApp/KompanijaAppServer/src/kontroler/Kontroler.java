/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DbKomunikacija;
import domen.Kompanija;
import domen.Mesto;
import domen.Proizvod;
import domen.Racun;
import java.util.List;
import so.OpstaSO;
import so.kompanija.SacuvajKompanijuSO;

/**
 *
 * @author Milica
 */
public class Kontroler {

    private static Kontroler instance;

    private DbKomunikacija db = new DbKomunikacija();

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<Mesto> vratiMesta() throws Exception {
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<Mesto> lm = db.vratiMesta();
        db.zatvoriKonekciju();
        return lm;
    }

    public void sacuvajKompaniju(Kompanija k) throws Exception {
//        db.ucitajDriver();
//        db.otvoriKonekciju();
//        db.sacuvajKompaniju(k);
//        db.commitTransakcije();
//        db.zatvoriKonekciju();
        OpstaSO soSacuvajKompaniju = new SacuvajKompanijuSO(k);
        soSacuvajKompaniju.izvrsenjeSO();
    }

    public List<Kompanija> vratiKompanije() throws Exception {
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<Kompanija> lk = db.vratiKompanije();
        db.zatvoriKonekciju();
        return lk;
    }

    public List<Proizvod> vratiProizvods() throws Exception {
        db.ucitajDriver();
        db.otvoriKonekciju();
        List<Proizvod> lp = db.vratiProizvode();
        db.zatvoriKonekciju();
        return lp;
    }

    public void sacuvajRacun(Racun racun) throws Exception {
        db.ucitajDriver();
        db.otvoriKonekciju();
        db.sacuvajRacun(racun);
        db.commitTransakcije();
        db.zatvoriKonekciju();
    }
}
