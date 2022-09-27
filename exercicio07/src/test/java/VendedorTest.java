import br.com.gft.model.Vendedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendedorTest {
    private Vendedor vendedor;

    @BeforeEach
    public void setup(){
        vendedor = new Vendedor("Maria", 22, 2000.0);
    }

    @Test
    public void deveRetornarBonificacaoSalarioMais5mil(){
        double bonificacao = vendedor.getBonificacao();
        assertEquals(5000.0, bonificacao, 0.0001);
    }

    @Test
    public void deveRetornarStringComDadosDoVendedor(){
        String esperado = "Vendedor-> nome: Maria, idade: 22, salario: 2000.0, bonificacao: 5000.0" ;

        assertEquals(esperado, vendedor.toString());
    }
}
