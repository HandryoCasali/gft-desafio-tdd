import br.com.gft.excecoes.ChamadoMetodoInvalidoException;
import br.com.gft.model.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {

    private Veiculo veiculo;

    @BeforeEach
    public void setup(){
        veiculo = new Veiculo();
    }

    @Test
    public void deveLigarOCarro(){
        veiculo.setIsLigado(false);
        veiculo.ligar();
        assertTrue(veiculo.getIsLigado());
    }

    @Test
    public void naoDeveLigarOCarroSeJaEstiverLigado(){
        veiculo.setIsLigado(true);
        assertThrows(ChamadoMetodoInvalidoException.class, veiculo::ligar);

    }

    @Test
    public void deveDesligarOCarro(){
        veiculo.setIsLigado(true);
        veiculo.desligar();
        assertFalse(veiculo.getIsLigado());
    }

    @Test
    public void naoDeveDesligarOCarroSeJaEstiverDesligado(){
        veiculo.setIsLigado(false);
        assertThrows(ChamadoMetodoInvalidoException.class, veiculo::desligar);
    }

    @Test
    public void naoDeveDesligarSeOVeiculoEstiverComVelocidadeAcimaDeZero(){
        veiculo.setIsLigado(true);
        veiculo.setVelocidade(100);
        assertThrows(ChamadoMetodoInvalidoException.class, veiculo::desligar);
    }

    @Test
    public void devePintarOCarro(){
        veiculo.pintar("azul");
        assertEquals("azul", veiculo.getCor());
    }

    @Test
    public void deveAbastecerOVeiculo(){
        veiculo.abastecer(20);
        assertEquals(20, veiculo.getLitrosCombustivel());
    }

    @Test
    public void deveAbastecerOVeiculoDesligado(){
        veiculo.setIsLigado(false);
        veiculo.abastecer(20);
        assertEquals(20, veiculo.getLitrosCombustivel());
    }

    @Test
    public void naoDeveAbastecerOVeiculoLigado(){
        veiculo.setIsLigado(true);
        assertThrows(ChamadoMetodoInvalidoException.class, ()-> veiculo.abastecer(20));
    }

    @Test
    public void deveAbastecerOVeiculoComQuantidadeNoLimiteDoTanque(){
        veiculo.abastecer(60);
        assertEquals(60, veiculo.getLitrosCombustivel());
    }

    @Test
    public void naoDeveAbastecerOVeiculoComQuantidadeAcimaDoLimiteDoTanque(){
        assertThrows(ChamadoMetodoInvalidoException.class, () -> veiculo.abastecer(70));
    }

    @Test
    public void naoDeveAbastecerOVeiculoComQuantidadeAcimaDoLimiteAtualDoTanque(){
        veiculo.setLitrosCombustivel(40);
        assertThrows(ChamadoMetodoInvalidoException.class, ()-> veiculo.abastecer(30));
    }

    @Test
    public void naoDeveAcelerarOCarroDesligado(){
        veiculo.setIsLigado(false);
        assertThrows(ChamadoMetodoInvalidoException.class,()-> veiculo.acelerar());
    }

    @Test
    public void deveAcelerarOCarroUmaVezEGanhar20DeVelocidade(){
        veiculo.ligar();
        veiculo.acelerar();
        assertEquals(20, veiculo.getVelocidade());
    }

    @Test
    public void deveAcelerarOCarroDuasVezesEGanhar40DeVelocidade(){
        veiculo.ligar();
        veiculo.acelerar();
        veiculo.acelerar();
        assertEquals(40, veiculo.getVelocidade());
    }

    @Test
    public void naoDeveFrearSeVelocidadeForZero(){
        veiculo.ligar();
        veiculo.setVelocidade(0);
        assertThrows(ChamadoMetodoInvalidoException.class, ()-> veiculo.frear());
    }

    @Test
    public void deveFrearOCarroUmaVezEPerder20DeVelocidade(){
        veiculo.ligar();
        veiculo.setVelocidade(20);
        veiculo.frear();
        assertEquals(0, veiculo.getVelocidade());
    }

    @Test
    public void deveFrearOCarroDuasVezesEPerder40DeVelocidade(){
        veiculo.ligar();
        veiculo.setVelocidade(40);
        veiculo.frear();
        veiculo.frear();
        assertEquals(0, veiculo.getVelocidade());
    }
}
