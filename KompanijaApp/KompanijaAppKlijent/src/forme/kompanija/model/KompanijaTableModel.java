/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kompanija.model;

import domen.Kompanija;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class KompanijaTableModel extends AbstractTableModel {

    private List<Kompanija> lk;
    private String[] kolone = {"KompanijaID", "Naziv", "Maticni broj", "Ulica", "Broj", "Mesto"};

    public KompanijaTableModel(List<Kompanija> lk) {
        this.lk = lk;
    }

    @Override
    public int getRowCount() {
        if (lk != null) {
            return lk.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kompanija k = lk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKompanijaID();
            case 1:
                return k.getNaziv();
            case 2:
                return k.getMaticniBroj();
            case 3:
                return k.getUlica();
            case 4:
                return k.getBroj();
            case 5:
                return k.getMesto();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Kompanija vratiKompaniju(int index) {
        return lk.get(index);
    }
    
    public void dodajRed() {
        lk.add(new Kompanija());
        fireTableDataChanged();
        System.out.println("Dodaj je novi red!");
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            return true;
        }
        return false;
    }
}
