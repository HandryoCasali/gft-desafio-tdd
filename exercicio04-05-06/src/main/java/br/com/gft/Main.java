package br.com.gft;

import br.com.gft.model.Pessoa;
import br.com.gft.model.PessoaRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        PessoaRepository pessoaRepository = new PessoaRepository();

        String opcao;
        do {
            menu();
            opcao = sc.nextLine();
            switch (opcao){
                case "1" -> {
                    pessoaRepository.adicionaPessoa(criarPessoa());
                    System.out.println("Pessoa adicionada!");
                }
                case "2" -> {
                    System.out.println("Digite o nome que deseja buscar");
                    String nome = sc.nextLine();
                    List<Pessoa> pessoasEncontrada = pessoaRepository.buscarPorNome(nome);
                    if(pessoasEncontrada.isEmpty()){
                        System.out.println("Não há pessoa com nome de " + nome + " adicionada na lista.");
                    }else {
                        System.out.println("Foram encontradas essas pessoas na lista: ");
                        pessoasEncontrada.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    Pessoa pessoaMaisVelha = pessoaRepository.buscaPessoaMaisVelha();
                    if(pessoaMaisVelha == null){
                        System.out.println("Não há pessoas adicionadas na lista!");
                    }else {
                        System.out.println("Essa é a pessoa mais velha da lista: " + pessoaMaisVelha);
                    }
                }
                case "4" -> {
                    System.out.println("Removendo pessoas da lista...");
                    pessoaRepository.removerPessoasMenoresIdade();
                }
                case "5" -> {
                    System.out.println("Listando Pessoas na lista...");
                    pessoaRepository.listaPessoa();
                }
                case "0" -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        }while(!opcao.equals("0"));
    }

    public static void menu(){
        System.out.print("""
                
                Escolha uma das opções:
                1- adicionar pessoa na lista;
                2- buscar nome na lista;
                3- buscar pessoa mais velha;
                4- remover pessoas menores de idade;
                5- listar pessoas;
                0- sair;
                Digite sua opção:\040""");
    }

    public static Pessoa criarPessoa(){
        System.out.print("Digite o nome da pessoa: ");
        String nome = sc.nextLine();
        System.out.print("Digite a idade da pessoa: ");
        int idade = sc.nextInt();
        sc.nextLine();
        return new Pessoa(nome, idade);
    }
}
