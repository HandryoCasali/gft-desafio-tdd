import br.com.gft.model.Guerreiro;
import br.com.gft.model.Mago;
import br.com.gft.model.Personagem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonagemTest {

    @Test
    public void deveRetornarONumeroDePersonagensCriados(){
        int quantidadeAtual = Personagem.getQuantidadePersonagensCriados();
        Mago m1 = new Mago();
        Mago m2 = new Mago();
        Mago m3 = new Mago();

        Guerreiro g1 = new Guerreiro();
        Guerreiro g2 = new Guerreiro();
        Guerreiro g3 = new Guerreiro();

        assertEquals(quantidadeAtual + 6, Personagem.getQuantidadePersonagensCriados());
    }

}
