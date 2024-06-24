package model.persistence.persistence;

import java.io.*;
import java.util.ArrayList;

import model.persistence.entities.Show;

public class GerenciadorArquivo {

    private static final String FILENAME = "shows.dat";

    public static void criarArquivoSeNaoExistir() throws IOException {
        File file = new File(FILENAME);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    @SuppressWarnings("unchecked")
    public static void lerArquivo(ArrayList<Show> listaShows) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILENAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        listaShows.addAll((ArrayList<Show>) ois.readObject());
        ois.close();
    }

    public static void salvarShowNoArquivo(ArrayList<Show> listaShows) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILENAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listaShows);
        oos.close();
    }

    public static void salvandoShow(ArrayList<Show> listaShows) throws IOException {
        salvarShowNoArquivo(listaShows);
    }
}