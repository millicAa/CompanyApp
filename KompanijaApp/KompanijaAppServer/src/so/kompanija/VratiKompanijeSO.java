/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kompanija;

import domen.Kompanija;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Milica
 */
public class VratiKompanijeSO extends OpstaSO {

    private List<Kompanija> listaKompanija;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaKompanija = db.vratiKompanije();
    }

    public List<Kompanija> getListaKompanija() {
        return listaKompanija;
    }
}
