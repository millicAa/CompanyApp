/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Kompanija;
import domen.Mesto;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import util.SettingsLoader;

/**
 *
 * @author Milica
 */
public class DbKomunikacija {

    private Connection connection;

    public void ucitajDriver() throws Exception {
        try {
            Class.forName(SettingsLoader.getInstance().getValue("driver"));
        } catch (ClassNotFoundException ex) {
            throw new Exception("Neodgovarajuci driver!" + ex.getMessage());
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            String url = SettingsLoader.getInstance().getValue("url");
            String user = SettingsLoader.getInstance().getValue("user");
            String password = SettingsLoader.getInstance().getValue("password");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false); // Zahteva eksplicitnu potvrdu transakcije
        } catch (SQLException ex) {
            throw new Exception("Konekcija nije uspostavljena!" + ex.getMessage());
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Konekcija nije zatvorena! " + ex.getMessage());
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije! " + ex.getMessage());
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije! " + ex.getMessage());
        }
    }

    public List<Mesto> vratiMesta() throws Exception {
        List<Mesto> lm = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Mesto";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int ptt = rs.getInt("Ptt");
                String naziv = rs.getString(2);
                Mesto m = new Mesto(ptt, naziv);
                lm.add(m);
            }
            return lm;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje liste mesta! " + ex.getMessage());
        }
    }

    public void sacuvajKompaniju(Kompanija k) throws Exception {
        try {
            //String sql = "INSERT INTO Kompanija(naziv, maticniBroj, ulica, broj, ptt) VALUES ('" + k.getNaziv() + "','" + k.getMaticniBroj() + "','" + k.getUlica()+ "','" + k.getBroj() + "'," + k.getMesto().getPtt() + ")";
            String sql = "INSERT INTO Kompanija(naziv, maticniBroj, ulica, broj, ptt) VALUES (?,?,?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sqlStatement.setString(1, k.getNaziv());
            sqlStatement.setString(2, k.getMaticniBroj());
            sqlStatement.setString(3, k.getUlica());
            sqlStatement.setString(4, k.getBroj());
            sqlStatement.setInt(5, k.getMesto().getPtt());
            sqlStatement.executeUpdate();
            ResultSet rs = sqlStatement.getGeneratedKeys();
            if (rs.next()) {
                int kompanijaID = rs.getInt(1);
                k.setKompanijaID(kompanijaID);
            } else {
                throw new Exception("KompanijaID nije generisan!");
            }

        } catch (SQLException ex) {
            throw new Exception("Neuspesno cuvanje kompanije! " + ex.getMessage());
        }
    }

    public List<Kompanija> vratiKompanije() throws Exception {
        try {
            List<Kompanija> lk = new LinkedList<>();
            String sql = "SELECT k.*, m.* FROM Kompanija k INNER JOIN Mesto m ON (k.ptt=m.ptt) ORDER BY k.naziv";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int kompanijaID = rs.getInt("kompanijaID");
                String naziv = rs.getString("k.naziv");
                String maticniBroj = rs.getString("maticniBroj");
                String ulica = rs.getString("ulica");
                String broj = rs.getString("broj");
                int ptt = rs.getInt("m.ptt");
                String nazivMesta = rs.getString("m.naziv");
                Mesto m = new Mesto(ptt, nazivMesta);
                Kompanija k = new Kompanija(naziv, maticniBroj, ulica, broj, m);
                k.setKompanijaID(kompanijaID);
                lk.add(k);
            }
            return lk;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje kompanija! " + ex.getMessage());
        }
    }

    public Mesto vratiMesto(int ptt) throws Exception {
        throw new Exception("Za domaci!");
    }

    public List<Proizvod> vratiProizvode() throws Exception {
        try {
            String sql = "SELECT * FROM Proizvod";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            List<Proizvod> lp = new ArrayList<>();
            while (rs.next()) {
                int proizvodID = rs.getInt("ProizvodID");
                String naziv = rs.getString(2);
                double cena = rs.getDouble("Cena");
                Proizvod p = new Proizvod(proizvodID, naziv, cena);
                lp.add(p);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje proizvoda", ex);
        }
    }

    public void sacuvajRacun(Racun racun) throws Exception {
        try {
            String sql = "INSERT INTO Racun VALUES (?,?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setInt(1, racun.getRacunID());
            sqlStatement.setDate(2, new java.sql.Date(racun.getDatum().getTime()));
            sqlStatement.setDouble(3, racun.getUkupanIznos());
            sqlStatement.setDouble(4, racun.getKompanija().getKompanijaID());
            sqlStatement.executeUpdate();

            PreparedStatement sqlSt = connection.prepareStatement("INSERT INTO StavkaRacuna VALUES (?,?,?,?,?,?)");
            for (StavkaRacuna s : racun.getStavkaList()) {
                sqlSt.setInt(1, racun.getRacunID());
                sqlSt.setInt(2, s.getRb());
                sqlSt.setInt(3, s.getKolicina());
                sqlSt.setDouble(4, s.getIznos());
                sqlSt.setInt(5, s.getProizvod().getProizvodID());
                sqlSt.setString(6, s.getJedinicaMere().toString());
                sqlSt.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new Exception("Neuspesno cuvanje racuna!", ex);
        }
    }

}
