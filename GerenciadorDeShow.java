package model.entities;

import java.util.ArrayList;

public interface GerenciadorDeShow {
    void salvarShow(Show show);
    ArrayList<Show> getListaShows();
    void verificarListaVazia() throws Exception;
    Show buscarShow(String nomeTurne) throws Exception;
    void apagarShow(Show show);
}
