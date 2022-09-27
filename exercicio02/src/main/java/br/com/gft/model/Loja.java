package br.com.gft.model;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nome;
    private String cnpj;
    private List<Livro> livros;
    private List<VideoGame> videoGames;

    public Loja(){ }

    public Loja(String nome, String cnpj, List<Livro> livros, List<VideoGame> videoGames) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.livros = livros;
        this.videoGames = videoGames;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<VideoGame> getVideoGames() {
        return videoGames;
    }

    public void setVideoGames(List<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    public void listaLivros() {
        if(this.livros.isEmpty()){
            System.out.println("A loja não tem livros no seu estoque.");
        }

        livros.forEach(livro -> System.out.println(livro.toString()));
    }

    public double calculaPatrimonio() {
        List<Produto> produtos = new ArrayList<>();
        produtos.addAll(livros);
        produtos.addAll(videoGames);

        return produtos.stream().mapToDouble(l -> l.getPreco() * l.getQtd())
                .sum();
    }

    public void listaVideoGames() {
        if(this.videoGames.isEmpty()){
            System.out.println("A loja não tem video-games no seu estoque.");
        }

        videoGames.forEach(vg -> System.out.println(vg.toString()));
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void adicionarVideoGame(VideoGame videoGame) {
        this.videoGames.add(videoGame);
    }
}
