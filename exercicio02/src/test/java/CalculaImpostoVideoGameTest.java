import br.com.gft.model.VideoGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculaImpostoVideoGameTest {
    private VideoGame videoGame;

    @BeforeEach
    public void setup(){
        this.videoGame = new VideoGame();
    }

    @Test
    public void deveCalcularImposto25PorCentoDoVideoGameUsado(){
        videoGame.setUsado(true);
        videoGame.setPreco(100.0);
        double imposto = videoGame.calculaImposto();
        assertEquals(25.0, imposto, 0.0001);
    }

    @Test
    public void deveCalcularImposto45PorCentoDoVideoGameNaoUsado(){
        videoGame.setUsado(false);
        videoGame.setPreco(100.0);
        double imposto = videoGame.calculaImposto();
        assertEquals(45.0, imposto, 0.0001);
    }
}
