package br.com.gft;

import br.com.gft.excecoes.ChamadoMetodoInvalidoException;
import br.com.gft.model.Veiculo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcao = "";
        Veiculo carro = new Veiculo();
        do {
            menu();
            opcao = sc.next();
            switch (opcao){
                case "1":
                    try{
                        carro.ligar();
                        System.out.println("Ligando o veiculo...");
                        System.out.println("Carro está ligado!");
                    }catch (ChamadoMetodoInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try{
                        carro.desligar();
                        System.out.println("Desligando o veiculo...");
                        System.out.println("Carro está desligado!");
                    }catch (ChamadoMetodoInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try{
                        carro.acelerar();
                        System.out.println("Acelerando o carro...");
                        System.out.println("Carro está numa velocidade de " + carro.getVelocidade() + "Km/h");
                    }catch (ChamadoMetodoInvalidoException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "4":
                    try{
                        carro.frear();
                        System.out.println("Freando o carro...");
                        System.out.println("Carro está numa velocidade de " + carro.getVelocidade() + "Km/h");
                    }catch (ChamadoMetodoInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    System.out.print("Digite a cor que deseja pintar o carro: ");
                    String cor = sc.next();
                    if(cor.isEmpty()){
                        System.out.println("Digite o nome da cor corretamente...");
                        break;
                    }
                    carro.pintar(cor);
                    System.out.println("O carro está novinho em folha com a cor " + carro.getCor());
                    break;
                case "6":
                    try{
                        System.out.print("Digite quantos litros quer abastecer: ");
                        int litros = sc.nextInt();
                        if(litros < 0){
                            System.out.println("Digite a quantidade de litros corretamente...");
                            break;
                        }
                        carro.abastecer(litros);
                        System.out.println("Carro está abastecido, com o total de " + carro.getLitrosCombustivel() + "L de combustível.");
                    }catch (ChamadoMetodoInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "7":
                    System.out.println("Carro está numa velocidade de " + carro.getVelocidade() + "Km/h");
                    break;
                case "0":
                    if (carro.getIsLigado()) {
                        System.out.println("Desligue o carro primeiro");
                        opcao = "";
                    }
                    System.out.println("Saindo do carro...");
                    System.out.println("Até a nossa proxima viagem!");
                    break;
                default:
                    System.out.println("Comando inválido, tente novamente!");
                    break;
            }

        }while (!opcao.equals("0"));
    }

    private static void menu(){
        System.out.println("""
                Escolha uma das opções para fazer com o carro: 
                1- ligar;
                2- desligar;
                3- acelerar;
                4- frear;
                5- pintar;
                6- abastecer;
                7- conferir velocímetro
                0- sair
                
                Digite sua opção: """);
    }
}
