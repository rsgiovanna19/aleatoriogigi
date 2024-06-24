package model.entities;
import java.util.ArrayList;

public class ListaShow implements GerenciadorDeShow {

    private static ArrayList<Show> listaShows = new ArrayList<>();

    @Override
    public void salvarShow(Show show) {
        listaShows.add(show);
    }

    @Override
    public ArrayList<Show> getListaShows() {
        return listaShows;
    }

    @Override
    public void verificarListaVazia() throws Exception {
        if (listaShows.isEmpty()) {
            throw new Exception("\nNão há shows cadastrados neste festival :( )");
        }
    }

    @Override
    public Show buscarShow(String nomeTurne) throws Exception {
        for(Show tempShow : listaShows) {
            if (tempShow.getNomeTurne().contains(nomeTurne)) {
                return tempShow;
            }
        }
        throw new Exception("Nome da turnê " + nomeTurne + " não encontrado");
    }

    @Override
    public void apagarShow(Show show) {
        listaShows.remove(show);
    }
}
