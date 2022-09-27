package br.com.gft.model;

public class Gerente extends Funcionario{

    public Gerente(){}

    public Gerente(String nome, int idade, double salario) {
        super(nome, idade, salario);
    }

    public double getBonificacao() {
        double bonus = 10000.0;
        return super.getBonificacao() + bonus;
    }

    @Override
    public String toString() {
        return "Gerente-> " +
                "nome: " + super.getNome() +
                ", idade: " + super.getIdade() +
                ", salario: " + super.getSalario() +
                ", bonificacao: " + this.getBonificacao();
    }
}
