package br.com.gft.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PessoaRepository {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void adicionaPessoa(Pessoa p){
        this.pessoas.add(p);
    }

    public Pessoa buscaPessoaMaisVelha(){
        if(pessoas.isEmpty()){
            return null;
        }
        return pessoas.stream()
                .max(Comparator.comparingInt(Pessoa::getIdade))
                .get();
    }

    public List<Pessoa> getPessoas() {
        return Collections.unmodifiableList(this.pessoas);
    }

    public void removerPessoasMenoresIdade() {
        this.pessoas = this.pessoas.stream()
                .filter(p1 -> p1.getIdade() >= 18)
                .toList();
    }

    public List<Pessoa> buscarPorNome(String nome) {
        return this.pessoas.stream()
                .filter((p) -> p.getNome().equals(nome))
                .toList();
    }

    public void listaPessoa(){
        if(this.pessoas.isEmpty()){
            System.out.println("Não há pessoas adicionadas na lista");
        }
        this.pessoas.forEach(System.out::println);
    }
}
