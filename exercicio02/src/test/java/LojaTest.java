import br.com.gft.model.Livro;
import br.com.gft.model.Loja;
import br.com.gft.model.VideoGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LojaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() throws IOException {
        outContent.close();
    }

    @Test
    public void devePrintarMensagemCasoListaLivrosEstiverVaziaNaHoraDeListar(){
        Loja loja = new LojaBuilder()
                .construir();
        loja.listaLivros();
        String esperado = "A loja não tem livros no seu estoque." + System.lineSeparator();
        assertEquals(esperado, outContent.toString());
    }

    @Test
    public void deveAdicionarLivro(){
        Loja loja = new Loja();
        loja.setLivros(new ArrayList<>());
        loja.adicionarLivro(new Livro());
        assertEquals(1, loja.getLivros().size());
    }


    @Test
    public void deveListarLivros(){
        Loja loja = new LojaBuilder()
                .comLivro(new Livro("Harry Potter", 40.0, 50, "", "Fantasia", 300))
                .comLivro(new Livro("O Senhor dos Aneis", 60.0, 30, "", "Fantasia", 500))
                .comLivro(new Livro("Java POO", 20.0, 50, "", "Educativo", 500))
                .construir();

        loja.listaLivros();

        String esperado = "Título: Harry Potter , preço: 40.0 , quantidade: 50 em estoque." + System.lineSeparator() +
                          "Título: O Senhor dos Aneis , preço: 60.0 , quantidade: 30 em estoque." + System.lineSeparator() +
                          "Título: Java POO , preço: 20.0 , quantidade: 50 em estoque." + System.lineSeparator();
        assertEquals(esperado, outContent.toString());
    }

    @Test
    public void devePrintarMensagemCasoListaVideoGamesEstiverVaziaNaHoraDeListar(){
        Loja loja = new LojaBuilder().construir();

        loja.listaVideoGames();

        String esperado = "A loja não tem video-games no seu estoque." + System.lineSeparator();
        assertEquals(esperado, outContent.toString());
    }

    @Test
    public void deveAdicionarVideoGame(){
        Loja loja = new Loja();
        loja.setVideoGames(new ArrayList<>());
        loja.adicionarVideoGame(new VideoGame());
        assertEquals(1, loja.getVideoGames().size());
    }

    @Test
    public void deveListarVideoGames(){
        Loja loja = new LojaBuilder()
                .comVideoGame(new VideoGame("PS4", 1800.0, 100, "Sony", "Slim", false))
                .comVideoGame(new VideoGame("PS4", 1000.0, 7, "Sony", "Slim", true))
                .comVideoGame(new VideoGame("XBOX", 1500.0, 500, "Microsoft", "One", false))
                .construir();

        loja.listaVideoGames();

        String esperado = "Video-Game: Slim , preço: 1800.0 , quantidade: 100 em estoque." + System.lineSeparator() +
                "Video-Game: Slim , preço: 1000.0 , quantidade: 7 em estoque." + System.lineSeparator() +
                "Video-Game: One , preço: 1500.0 , quantidade: 500 em estoque." + System.lineSeparator();
        assertEquals(esperado, outContent.toString());
    }

    @Test
    public void deveCalcularPatrimonioLojaComItensNaLista(){
        Loja loja = new LojaBuilder()
                .comLivro(new Livro("Harry Potter", 40.0, 50, "", "Fantasia", 300))
                .comLivro(new Livro("O Senhor dos Aneis", 60.0, 30, "", "Fantasia", 500))
                .comLivro(new Livro("Java POO", 20.0, 50, "", "Educativo", 500))
                .comVideoGame(new VideoGame("PS4", 1800.0, 100, "", "", false))
                .comVideoGame(new VideoGame("PS4", 1000.0, 7, "", "", true))
                .comVideoGame(new VideoGame("XBOX", 1500.0, 500, "", "", false))
                .construir();

        double totalPatrimonio = loja.calculaPatrimonio();
        assertEquals(941800.0, totalPatrimonio, 0.0001);
    }

    @Test
    public void CalcularPatrimonioLojaDeveRetornar0ParaListaVazia(){
        Loja loja = new LojaBuilder().construir();
        double totalPatrimonio = loja.calculaPatrimonio();
        assertEquals(0.0, totalPatrimonio, 0.0001);
    }
}
