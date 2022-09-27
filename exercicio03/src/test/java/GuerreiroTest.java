import br.com.gft.model.Guerreiro;
import br.com.gft.model.Personagem;
import br.com.gft.util.NumeroRandomico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuerreiroTest {
    private Guerreiro guerreiro;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    private NumeroRandomico random;

    @BeforeEach
    public void setup(){
        guerreiro = new Guerreiro();
        guerreiro.setNome("Kirito");
        random = Mockito.mock(NumeroRandomico.class);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() throws IOException {
        outContent.close();
    }

    @Test
    public void deveAtacar(){
        guerreiro.setNumeroRandomico(random);
        Mockito.when(random.numeroRandom(301)).thenReturn(10);
        guerreiro.lvlUp();
        int valorEsperadoAttack = guerreiro.getForca() * guerreiro.getLevel() + 10;
        assertEquals(valorEsperadoAttack, guerreiro.attack());
    }

    @Test
    public void deveSubirDeLevel(){
        guerreiro.lvlUp();
        verificaAtributosPersonagens(guerreiro, 1, 1, 1, 4, 3);
    }

    @Test
    public void deveAprenderMagia(){
        guerreiro.aprenderHabilidade("Espada Dupla");
        assertTrue(guerreiro.getHabilidade().contains("Espada Dupla"));
    }

    @Test
    public void deveMostrarStatus(){
        guerreiro.lvlUp();
        String esperado = "nome= Kirito, level=1, vida=4, mana=1, inteligencia=1, forca=3" + System.lineSeparator();
        guerreiro.mostrarStatus();
        assertEquals(esperado, outContent.toString());
    }

    private void verificaAtributosPersonagens(Personagem personagem, int level, int mana, int inteligencia, int vida, int forca) {
        assertEquals(level, personagem.getLevel());
        assertEquals(mana, personagem.getMana());
        assertEquals(inteligencia, personagem.getInteligencia());
        assertEquals(vida, personagem.getVida());
        assertEquals(forca, personagem.getForca());
    }
}
