import br.com.gft.model.Mago;
import br.com.gft.model.Personagem;
import br.com.gft.util.NumeroRandom;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;

public class MagoTest {

    private Mago mago;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static MockedStatic<NumeroRandom> nr;

    @BeforeAll
    static void setUp() {
        nr = mockStatic(NumeroRandom.class);
    }

    @AfterAll
    static void tearDown() {
        nr.close();
    }

    @BeforeEach
    public void setup(){
        mago = new Mago();
        mago.setNome("Gandalf");
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void close() throws IOException {
        outContent.close();
    }

    @Test
    public void deveAtacar(){
        nr.when(() -> NumeroRandom.numeroRandom(301)).thenReturn(10);
        mago.mostrarStatus();
        mago.lvlUp();
        int valorEsperadoAttack = mago.getInteligencia() * mago.getLevel() + 10;
        assertEquals(valorEsperadoAttack, mago.attack());
    }

    @Test
    public void deveSubirDeLevel(){
        mago.lvlUp();
        mago.mostrarStatus();
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
