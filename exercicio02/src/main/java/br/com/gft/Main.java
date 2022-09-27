package br.com.gft;

import br.com.gft.model.Livro;
import br.com.gft.model.Loja;
import br.com.gft.model.VideoGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema de gerenciamento do estoque da loja.");
        Loja loja = criarLoja();

        String opcao;
        do {
            menu();
            opcao = sc.nextLine();

            switch (opcao) {
                case "1" -> {
                    loja.adicionarLivro(criarLivroComEntradaUsuario());
                    System.out.println("Livro adicionado!");
                }
                case "2" -> {
                    loja.adicionarVideoGame(criarVideoComEntradaUsuario());
                    System.out.println("VideoGame adicionado!");
                }
                case "3" -> loja.listaLivros();
                case "4" -> loja.listaVideoGames();
                case "0" -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        }while(!opcao.equals("0"));

    }

    private static void menu(){
        System.out.println("""
                Escolha uma das opções a seguir:
                1- adicionar Livro na loja
                2- adicionar VideoGame na loja
                3- listar livros da loja
                4- listar videogames da loja
                0- sair do sitema
                Digite sua opção:\040""");

    }

    private static Loja criarLoja(){
        System.out.print("Digite o nome do loja: ");
        String nome = sc.nextLine();

        System.out.print("Digite o cnpj da loja: ");
        String cnpj = sc.nextLine();

        System.out.println(nome + " " + cnpj);
        return new Loja(nome, cnpj, new ArrayList<>(),new ArrayList<>());
    }

    private static Livro criarLivroComEntradaUsuario(){

        System.out.print("Digite o nome do livro: ");
        String nome = sc.nextLine();

        System.out.print("Digite o preco do livro: ");
        double preco = sc.nextDouble();

        System.out.print("Digite a quantidade de livro no estoque: ");
        int qtd = sc.nextInt();

        sc.nextLine();

        System.out.print("Digite o nome do autor do livro: ");
        String autor = sc.nextLine();

        System.out.print("Digite o tema do livro: ");
        String tema = sc.nextLine();

        System.out.print("Digite a quantidade de paginas do livro: ");
        int qtdPaginas = sc.nextInt();

        sc.nextLine();
        return new Livro(nome, preco, qtd, autor, tema,qtdPaginas);
    }

    private static VideoGame criarVideoComEntradaUsuario(){
        System.out.print("Digite o nome do videogame: ");
        String nome = sc.nextLine();

        System.out.print("Digite o preco do videogame: ");
        double preco = sc.nextDouble();

        System.out.print("Digite a quantidade de videogame no estoque: ");
        int qtd = sc.nextInt();

        sc.nextLine();

        System.out.print("Digite a marca do videogame: ");
        String marca = sc.nextLine();

        System.out.print("Digite o modelo do videogame: ");
        String modelo = sc.nextLine();

        System.out.print("Digite se o videogame é usado (S/N):  ");
        String entradaUsado = sc.nextLine();
        boolean usado = entradaUsado.equalsIgnoreCase("s");

        return new VideoGame(nome, preco, qtd, marca, modelo,usado);
    }
}
