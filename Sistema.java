package controller;

import java.util.ArrayList;

import model.entities.GerenciadorDeShow;
import model.entities.ListaShow;
import model.entities.Show;
import model.persistence.GerenciadorArquivo;
import view.Console;

public class Sistema {

    private static GerenciadorDeShow gerenciador = new ListaShow();

    static ArrayList<Show> listaShows = gerenciador.getListaShows();
   
    public static void executarSistema() {
        carregarDadosDoArquivo();

        while (true) {
            exibirMenu();
            int op = Console.lerInt("Informe uma opção");
            verificarOpcaoMenu(op);
        }
    }

    private static void exibirMenu() {
        System.out.println("\nBem-vindos ao Master Ingresso!");
        System.out.println("1) Cadastrar Show");
        System.out.println("2) Listar todos");
        System.out.println("3) Buscar Show");
        System.out.println("4) Apagar Show");
        System.out.println("5) Atualizar dados do show");
        System.out.println("0) Sair");
    }

    private static void verificarOpcaoMenu(int op) {
        switch (op) {
            case 1:
                salvarShow();
                break;

            case 2:
                listarShows();
                break;

            case 3:
                buscarShow();
                break;

            case 4:
                apagarShow();
                break;

            case 5:
                atualizarShow();
                break;

            case 0:
                System.out.println("\nO Sistema foi finalizado...\n");
                System.exit(0);
                break;
        
            default:
                System.out.println("\nOpção inválida. Digite novamente.");
                break;
        }
    }
    
    private static void atualizarShow() {
        try {
            gerenciador.verificarListaVazia();
            System.out.println("\nInforme o nome da turnê que deseja atualizar:");
            String nomeTurne = Console.lerString("Nome da Turnê");
            Show tempShow = gerenciador.buscarShow(nomeTurne);
            System.out.println("\nShow Localizado:" + tempShow.exibirDados() + "\nInforme novos dados:\n");
            nomeTurne = Console.lerString("Novo nome da turnê");
            String cantor = Console.lerString("Novo cantor");
            tempShow.setNomeTurne(nomeTurne);
            tempShow.setCantor(cantor);
            GerenciadorArquivo.salvarShowNoArquivo(listaShows);
            System.out.println("\nShow atualizado com sucesso:" + tempShow.exibirDados());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void carregarDadosDoArquivo() {
        try {
            GerenciadorArquivo.criarArquivoSeNaoExistir();
            GerenciadorArquivo.lerArquivo(listaShows);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void salvarShow() {
        System.out.println("\nNovo Show");
        String nomeTurne = Console.lerString("Informe o nome da turnê");
        String cantor = Console.lerString("Informe o cantor");
        Show show = new Show(nomeTurne, cantor);
        try {
            gerenciador.salvarShow(show);
            GerenciadorArquivo.salvandoShow(listaShows);
            System.out.println("\nShow foi salvo no arquivo!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarShows() {
        try {
            gerenciador.verificarListaVazia();
            System.out.println("\nShows Cadastrados");
            for(Show tempShow : listaShows) {
                System.out.println(tempShow.exibirDados());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarShow() {
        try {
            gerenciador.verificarListaVazia();
            System.out.println("\nBuscar show por nome da turnê.");
            String nomeTurne = Console.lerString("Informe o nome da turnê");
            Show tempShow = gerenciador.buscarShow(nomeTurne);
            System.out.println("\nShow encontrado:" + tempShow.exibirDados());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void apagarShow() {
        try {
            gerenciador.verificarListaVazia();
            System.out.println("\nInforme a turnê que deseja excluir:");
            String nomeTurne = Console.lerString("Nome da Turnê");
            Show tempShow = gerenciador.buscarShow(nomeTurne);
            gerenciador.apagarShow(tempShow);
            GerenciadorArquivo.salvarShowNoArquivo(listaShows);
            System.out.println("\nShow localizado: " + tempShow.exibirDados());
            System.out.println("\nShow " + tempShow.getNomeTurne() + " apagado com sucesso do arquivo!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}