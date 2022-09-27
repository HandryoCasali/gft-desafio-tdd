import br.com.gft.model.Gerente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GerenteTest {

    private Gerente gerente;

    @BeforeEach
    public void setup(){
        gerente = new Gerente("João", 40, 6000.0);
    }

    @Test
    public void deveRetornarBonificacaoSalarioMais10mil(){
        double bonificacao = gerente.getBonificacao();
        assertEquals(16000.0, bonificacao, 0.0001);
    }

    @Test
    public void deveRetornarStringComDadosDoGerente(){
        String esperado = "Gerente-> nome: João, idade: 40, salario: 6000.0, bonificacao: 16000.0" ;

        assertEquals(esperado, gerente.toString());
    }
}
