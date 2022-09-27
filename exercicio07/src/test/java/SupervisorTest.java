import br.com.gft.model.Supervisor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupervisorTest {
    private Supervisor sv;

    @BeforeEach
    public void setup(){
        sv  = new Supervisor("Pedro", 35, 4000.0);
    }

    @Test
    public void deveRetornarBonificacaoSalarioMais5mil(){
        double bonificacao = sv.getBonificacao();
        assertEquals(9000.0, bonificacao, 0.0001);
    }

    @Test
    public void deveRetornarStringComDadosDoSupervisor(){
        String esperado = "Supervisor-> nome: Pedro, idade: 35, salario: 4000.0, bonificacao: 9000.0" ;

        assertEquals(esperado, sv.toString());
    }
}
