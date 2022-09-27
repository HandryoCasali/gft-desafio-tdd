import br.com.gft.model.Livro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculaImpostoLivroTest {

    private Livro livro;

    @BeforeEach
    public void setup(){
        this.livro = new Livro();
    }

    @Test
    public void deveRetornarImposto0SeOLivroForTemaEducativo(){
        livro.setTema("Educativo");
        livro.setPreco(100.0);
        double imposto = livro.calculaImposto();
        assertEquals(0, imposto, 0.0001);
    }

    @Test
    public void deveRetornarOCalculoDoImpostoSeNaoForTemaEducativo(){
        livro.setTema("Fantasia");
        livro.setPreco(100.0);
        double imposto = livro.calculaImposto();
        assertEquals(10.0, imposto, 0.0001);
    }
}
