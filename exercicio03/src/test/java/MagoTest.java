import br.com.gft.model.Mago;
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

public class MagoTest {

    private Mago mago;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    private NumeroRandomico random;

    @BeforeEach
    public void setup(){
        mago = new Mago();
        mago.setNome("Gandalf");
        random = Mockito.mock(NumeroRandomico.class);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() throws IOException {
        outContent.close();
    }

    @Test
    public void deveAtacar(){
        mago.setNumeroRandomico(random);
        Mockito.when(random.numeroRandom(301)).thenReturn(10);
        mago.lvlUp();
        int valorEsperadoAttack = mago.getInteligencia() * mago.getLevel() + 10;
        assertEquals(valorEsperadoAttack, mago.attack());
    }

    @Test
    public void deveSubirDeLevel(){
        mago.lvlUp();
        verificaAtributosPersonagens(mago, 1, 4, 3, 1, 1);
    }

    @Test
    public void deveAprenderMagia(){
        mago.aprenderMagia("Avada Kedavra");
        assertTrue(mago.getMagia().contains("Avada Kedavra"));
    }

    @Test
    public void deveMostrarStatus(){
        mago.lvlUp();
        String esperado = "nome= Gandalf, level=1, vida=1, mana=4, inteligencia=3, forca=1" + System.lineSeparator();
        mago.mostrarStatus();
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
