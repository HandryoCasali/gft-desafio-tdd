package br.com.gft.model;

public class Vendedor extends Funcionario{

    public Vendedor(){}

    public Vendedor(String nome, int idade, double salario) {
        super(nome, idade, salario);
    }

    public double getBonificacao() {
        double bonus = 3000.0;
        return super.getBonificacao() + bonus;
    }

    @Override
    public String toString() {
        return "Vendedor-> " +
                "nome: " + super.getNome() +
                ", idade: " + super.getIdade() +
                ", salario: " + super.getSalario() +
                ", bonificacao: " + this.getBonificacao();
    }
}
