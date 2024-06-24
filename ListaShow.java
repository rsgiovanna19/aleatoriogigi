package model.persistence.entities;
import java.util.ArrayList;

public abstract class ListaShow {

    private static ArrayList<Show> listaShows = new ArrayList<>();

    public static void salvarShow(Show show) {
        listaShows.add(show);
    }

    public static ArrayList<Show> getListaShows() {
        return listaShows;
    }

    public static void verificarListaVazia() throws Exception {

        if (listaShows.isEmpty()) {
            throw new Exception("\nNão há shows cadastrados neste festival :( )");
        }

    }

    public static Show buscarShow (String nomeTurne) throws Exception {

        for(Show tempShow : listaShows) {

            if (tempShow.getNomeTurne().contains(nomeTurne)) {
                return tempShow;
            }
        }

        throw new Exception("Nome da turnê " + nomeTurne + " não encontrado");
    }

    public static void apagarShow(Show show) {
        listaShows.remove(show);
    }
}
