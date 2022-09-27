package br.com.gft.model;

public class Supervisor extends Funcionario{
    public Supervisor(){}

    public Supervisor(String nome, int idade, double salario) {
        super(nome, idade, salario);
    }

    public double getBonificacao() {
        double bonus = 5000.0;
        return super.getBonificacao() + bonus;
    }

    @Override
    public String toString() {
        return "Supervisor-> " +
                "nome: " + super.getNome() +
                ", idade: " + super.getIdade() +
                ", salario: " + super.getSalario() +
                ", bonificacao: " + this.getBonificacao();
    }
}
