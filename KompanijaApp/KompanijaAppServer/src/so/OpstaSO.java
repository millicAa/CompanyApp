/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DbKomunikacija;

/**
 *
 * @author Milica
 */
public abstract class OpstaSO {

    protected Object obj;
    protected DbKomunikacija db;

    public OpstaSO(Object obj) {
        this.obj = obj;
        this.db = new DbKomunikacija();
    }

    public OpstaSO() {
        this.db = new DbKomunikacija();
    }

    public final void izvrsenjeSO() throws Exception {
        try {
            ucitajDriver();
            otvoriKonekciju();
            proveriPreduslov(obj);
            izvrsiOperaciju(obj);
            commitTransakcije();
        } catch (Exception ex) {
            rollbackTransakcije();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }
    }

    private void ucitajDriver() throws Exception {
        db.ucitajDriver();
    }

    private void otvoriKonekciju() throws Exception {
        db.otvoriKonekciju();
    }

    protected abstract void proveriPreduslov(Object obj) throws Exception;

    protected abstract void izvrsiOperaciju(Object obj) throws Exception;

    private void commitTransakcije() throws Exception {
        db.commitTransakcije();
    }

    private void rollbackTransakcije() throws Exception {
        db.rollbackTransakcije();
    }

    private void zatvoriKonekciju() throws Exception {
        db.zatvoriKonekciju();
    }

}
