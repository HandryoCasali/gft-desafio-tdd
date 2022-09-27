import br.com.gft.model.Livro;
import br.com.gft.model.Loja;
import br.com.gft.model.VideoGame;

import java.util.ArrayList;
import java.util.List;

public class LojaBuilder {
    private Loja instancia;
    private List<Livro> livros = new ArrayList<>();
    private List<VideoGame> videoGames = new ArrayList<>();
    
    public Loja construir(){
        this.instancia = new Loja();
        this.instancia.setLivros(livros);
        this.instancia.setVideoGames(videoGames);
        return this.instancia;
    }

    public LojaBuilder comLivro(Livro livro){
        this.livros.add(livro);
        return this;
    }

    public LojaBuilder comVideoGame(VideoGame videoGame){
        this.videoGames.add(videoGame);
        return this;
    }


}
