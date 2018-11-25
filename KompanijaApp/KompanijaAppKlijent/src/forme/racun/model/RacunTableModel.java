/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.racun.model;

import domen.JedinicaMere;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica
 */
public class RacunTableModel extends AbstractTableModel {

    private Racun racun;
    private String[] kolone = {"Proizvod", "Cena", "Kolicina", "JM", "Iznos"};

    public RacunTableModel(Racun racun) {
        this.racun = racun;
    }

    @Override
    public int getRowCount() {
        if (racun == null) {
            return 0;
        }
        return racun.getStavkaList().size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna stavka = racun.getStavkaList().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavka.getProizvod();
            case 1:
                return stavka.getProizvod().getCena();
            case 2:
                return stavka.getKolicina();
            case 3:
                return stavka.getJedinicaMere();
            case 4:
                return stavka.getIznos();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1 || columnIndex == 4) {
            return false;
        }
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaRacuna stavka = racun.getStavkaList().get(rowIndex);
        switch (columnIndex) {
            case 0:
                stavka.setProizvod((Proizvod) aValue);
                stavka.setIznos(stavka.getProizvod().getCena() * stavka.getKolicina());
                fireTableCellUpdated(rowIndex, 1);
                fireTableCellUpdated(rowIndex, 4);
                break;
            case 1: // Cena se ne menja
                break;
            case 2:
                stavka.setKolicina(Integer.parseInt((String) aValue));
                stavka.setIznos(stavka.getProizvod().getCena() * stavka.getKolicina());
                fireTableCellUpdated(rowIndex, 4);
                break;
            case 3:
                stavka.setJedinicaMere(JedinicaMere.valueOf(aValue.toString()));
                break;
            case 4: // Iznos se ne menja
                break;
        }
    }

    public void dodajStavku() {
        racun.dodajStavku();
        fireTableDataChanged();
    }

    public void obrisiStavku(int index) {
        racun.getStavkaList().remove(index);
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1 || columnIndex == 4) {
            return Double.class;
        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Racun getRacun() {
        return racun;
    }

}
