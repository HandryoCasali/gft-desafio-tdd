package br.com.gft.model;

import br.com.gft.interfaces.Imposto;

public class Livro extends Produto implements Imposto {
    private String autor;
    private String tema;
    private int qtdPag;

    public Livro(){ }

    public Livro(String nome, double preco, int qtd, String autor, String tema, int qtdPag) {
        super(nome, preco, qtd);
        this.autor = autor;
        this.tema = tema;
        this.qtdPag = qtdPag;
    }

    @Override
    public double calculaImposto() {
        if(this.tema.equalsIgnoreCase("educativo")){
            return 0;
        }
        return super.getPreco() * 0.1;
    }

    @Override
    public String toString() {
        return "Título: " + super.getNome() +
                " , preço: " + super.getPreco() +
                " , quantidade: " + super.getQtd() + " em estoque.";
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getQtdPag() {
        return qtdPag;
    }

    public void setQtdPag(int qtdPag) {
        this.qtdPag = qtdPag;
    }
}
