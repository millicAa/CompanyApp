/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;

/**
 *
 * @author Milica
 */
public class Komunikacija {

    private Socket socket;
    private static Komunikacija instance;

    private Komunikacija() throws IOException {
        socket = new Socket("localhost", 9000);
    }

    public static Komunikacija getInstance() throws IOException {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void posalji(TransferObjekatZahtev toZahtev) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(toZahtev);
    }

    public TransferObjekatOdgovor procitaj() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return (TransferObjekatOdgovor) in.readObject();
    }

}
