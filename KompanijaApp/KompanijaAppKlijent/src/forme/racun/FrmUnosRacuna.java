/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.racun;

import domen.JedinicaMere;
import domen.Kompanija;
import domen.Proizvod;
import domen.Racun;
import forme.kompanija.FrmPretragaKompanija;
import forme.racun.model.RacunTableModel;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

/**
 *
 * @author Milica
 */
public class FrmUnosRacuna extends javax.swing.JPanel {

    /**
     * Creates new form FrmRacun
     */
    public FrmUnosRacuna() {
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtRacunID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtDatum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbKompanija = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRacun = new javax.swing.JTable();
        jbtnDodajStavku = new javax.swing.JButton();
        jbtnObrisiStavku = new javax.swing.JButton();
        jbtnSnimiRacun = new javax.swing.JButton();
        jbtnPretraga = new javax.swing.JButton();

        jLabel1.setText("RacunID:");

        jLabel2.setText("Datum (dd.MM.yyyy):");

        jLabel3.setText("Kompanija:");

        jcbKompanija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtblRacun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblRacun);

        jbtnDodajStavku.setText("Dodaj stavku");
        jbtnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajStavkuActionPerformed(evt);
            }
        });

        jbtnObrisiStavku.setText("Obrisi stavku");
        jbtnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiStavkuActionPerformed(evt);
            }
        });

        jbtnSnimiRacun.setText("Snimi racun");
        jbtnSnimiRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSnimiRacunActionPerformed(evt);
            }
        });

        jbtnPretraga.setText("Pretraga");
        jbtnPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretragaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71)
                        .addComponent(jtxtRacunID))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtDatum)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbKompanija, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnPretraga))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtnSnimiRacun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnDodajStavku)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnObrisiStavku)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtRacunID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbKompanija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnPretraga)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDodajStavku)
                    .addComponent(jbtnObrisiStavku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnSnimiRacun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajStavkuActionPerformed
        RacunTableModel model = (RacunTableModel) jtblRacun.getModel();
        model.dodajStavku();
    }//GEN-LAST:event_jbtnDodajStavkuActionPerformed

    private void jbtnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiStavkuActionPerformed
        int index = jtblRacun.getSelectedRow();
        if (index != -1) {
            RacunTableModel model = (RacunTableModel) jtblRacun.getModel();
            model.obrisiStavku(index);
        } else {
            JOptionPane.showMessageDialog(this, "Odaberite stavku koju zelite da obrisete!");
        }
    }//GEN-LAST:event_jbtnObrisiStavkuActionPerformed

    private void jbtnSnimiRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSnimiRacunActionPerformed
        try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            int racunID = Integer.parseInt(jtxtRacunID.getText().trim());
            Date datum = df.parse(jtxtDatum.getText().trim());
            Kompanija k = (Kompanija) jcbKompanija.getSelectedItem();
            
            RacunTableModel model = (RacunTableModel) jtblRacun.getModel();
            Racun racun = model.getRacun();
            racun.setRacunID(racunID);
            racun.setDatum(datum);
            racun.setKompanija(k);
            racun.pripremiRacun();
            
            //Kontroler.getInstance().sacuvajRacun(racun);
            JOptionPane.showMessageDialog(this, "Racun je sacuvan! Iznos: " + racun.getUkupanIznos());
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jbtnSnimiRacunActionPerformed

    private void jbtnPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretragaActionPerformed
        FrmPretragaKompanija f = new FrmPretragaKompanija(this);
        JDialog dialog = new JDialog((JDialog) SwingUtilities.getWindowAncestor(this), "Pretraga kompanija", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(f, BorderLayout.CENTER);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jbtnPretragaActionPerformed

    public JComboBox getJcbKompanija() {
        return jcbKompanija;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDodajStavku;
    private javax.swing.JButton jbtnObrisiStavku;
    private javax.swing.JButton jbtnPretraga;
    private javax.swing.JButton jbtnSnimiRacun;
    private javax.swing.JComboBox jcbKompanija;
    private javax.swing.JTable jtblRacun;
    private javax.swing.JTextField jtxtDatum;
    private javax.swing.JTextField jtxtRacunID;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        try {
            // Ucitavnje kompanija
            //List<Kompanija> lk = Kontroler.getInstance().vratiKompanije();
            List<Kompanija> lk = new LinkedList<>();
            jcbKompanija.removeAllItems();
            for (Kompanija k : lk) {
                jcbKompanija.addItem(k);
            }

            // Postavljanje modela tabele
            RacunTableModel model = new RacunTableModel(new Racun());
            jtblRacun.setModel(model);

            // Postavljanje combobox-a Proizvod
            //List<Proizvod> lp = Kontroler.getInstance().vratiProizvods();
            List<Proizvod> lp = new LinkedList<>();
            JComboBox jcbProizvod = new JComboBox();
            for (Proizvod p : lp) {
                jcbProizvod.addItem(p);
            }
            TableColumn tcProizvod = jtblRacun.getColumnModel().getColumn(0);
            tcProizvod.setCellEditor(new DefaultCellEditor(jcbProizvod));
            
            // Postavljanje combobox-a Jedincica mere
            JComboBox jcbJedinicaMere = new JComboBox();
            jcbJedinicaMere.addItem(JedinicaMere.KOM);
            jcbJedinicaMere.addItem(JedinicaMere.L);
            jcbJedinicaMere.addItem(JedinicaMere.KG);
            jcbJedinicaMere.addItem(JedinicaMere.M);
            
            TableColumn tcJedinicaMere = jtblRacun.getColumnModel().getColumn(3);
            tcJedinicaMere.setCellEditor(new DefaultCellEditor(jcbJedinicaMere));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
