/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.Kompanija;
import domen.Mesto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import kontroler.Kontroler;
import transfer.Operacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;

/**
 *
 * @author Milica
 */
public class Komunikacija {

    private Socket socket;
    private boolean aktivan = true;
    
    public void pokreniServer() throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut");
        socket = ss.accept();
        System.out.println("Klijent se povezao");
        izvrsenjeOperacija();
    }

    private void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (aktivan) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            TransferObjekatZahtev toZahtev = (TransferObjekatZahtev) inSocket.readObject();
            TransferObjekatOdgovor toOdgovor = new TransferObjekatOdgovor();
            System.out.println("Operacija: " + toZahtev.getOperacija());
            try {
                switch (toZahtev.getOperacija()) {
                    case Operacija.VRATI_MESTA:
                        List<Mesto> lm = Kontroler.getInstance().vratiMesta();
                        toOdgovor.setRezultat(lm);
                        break;
                    case Operacija.VRATI_KOMPANIJE:
                        List<Kompanija> lk = Kontroler.getInstance().vratiKompanije();
                        toOdgovor.setRezultat(lk);
                        break;
                    case Operacija.SACUVAJ_KOMPANIJU:
                        Kompanija k = (Kompanija) toZahtev.getParametar();
                        Kontroler.getInstance().sacuvajKompaniju(k);
                        toOdgovor.setPoruka("OK");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                toOdgovor.setIzuzetak(ex);
                toOdgovor.setPoruka(ex.getMessage());
            }
            posalji(toOdgovor);
        }
    }

    private void posalji(TransferObjekatOdgovor toOdgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdgovor);
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Komunikacija k = new Komunikacija();
        k.pokreniServer();
    }


}
