/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kompanija;

import domen.Kompanija;
import so.OpstaSO;

/**
 *
 * @author Milica
 */
public class SacuvajKompanijuSO extends OpstaSO {

    public SacuvajKompanijuSO(Object obj) {
        super(obj);
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        System.out.println("Provera preduslova za cuvanje kompanije");
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        db.sacuvajKompaniju((Kompanija) obj);
    }

}
