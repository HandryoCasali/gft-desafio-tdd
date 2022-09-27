import br.com.gft.model.Pessoa;
import br.com.gft.model.PessoaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaRepositoryTest {

    private PessoaRepository pessoaRepository;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup(){
        pessoaRepository = new PessoaRepository();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() throws IOException {
        outContent.close();
    }


    @Test
    public void deveAdicionarPessoaNaLista(){
        Pessoa pessoa = new Pessoa("João", 15);
        pessoaRepository.adicionaPessoa(pessoa);

        boolean contem = pessoaRepository.getPessoas().contains(pessoa);
        assertTrue(contem);
    }

    @Test void devePrintarMensagemCasoNaoHouverPessoasAdicionadasNaListaAntesDeListar(){
        pessoaRepository.listaPessoa();
        String esperado = "Não há pessoas adicionadas na lista" + System.lineSeparator();
        assertEquals(esperado, outContent.toString());
    }

    @Test
    public void deveListarPessoas(){
        Pessoa p1 = new Pessoa("João", 15);
        Pessoa p2 = new Pessoa("Leandro", 21);
        pessoaRepository.adicionaPessoa(p1);
        pessoaRepository.adicionaPessoa(p2);
        pessoaRepository.listaPessoa();
        String esperado = "nome= João, idade= 15" + System.lineSeparator() +
                          "nome= Leandro, idade= 21" + System.lineSeparator();
        assertEquals(esperado, outContent.toString());
    }

    @Test
    public void deveRetornarNullSeAListaForVaziaNaHoraDeBuscarPorPessoaMaisVelha(){
        Pessoa pessoaMaisVelha = pessoaRepository.buscaPessoaMaisVelha();
        assertNull(pessoaMaisVelha);
    }

    @Test
    public void deveBuscarAPessoaMaisVelha(){
        Pessoa p1 = new Pessoa("João", 15);
        Pessoa p2 = new Pessoa("Leandro", 21);
        Pessoa p3 = new Pessoa("Paulo", 17);
        Pessoa p4 = new Pessoa("Jessica", 21);
        adicionaPessoasLista(p1, p2, p3, p4);
        Pessoa pessoaMaisVelha = pessoaRepository.buscaPessoaMaisVelha();
        assertEquals(p2, pessoaMaisVelha);
    }

    @Test
    public void deveExcluirAsPessoasMenoresDeIdadeDaLista(){
        Pessoa p1 = new Pessoa("João", 15);
        Pessoa p2 = new Pessoa("Leandro", 21);
        Pessoa p3 = new Pessoa("Paulo", 17);
        Pessoa p4 = new Pessoa("Jessica", 18);
        adicionaPessoasLista(p1, p2, p3, p4);
        pessoaRepository.removerPessoasMenoresIdade();
        assertEquals(2, pessoaRepository.getPessoas().size());
    }

    @Test
    public void deveBuscarPessoasPorNome(){
        Pessoa p1 = new Pessoa("João", 15);
        Pessoa p2 = new Pessoa("Leandro", 21);
        Pessoa p3 = new Pessoa("Paulo", 17);
        Pessoa p4 = new Pessoa("Jessica", 18);
        adicionaPessoasLista(p1, p2, p3, p4);
        List<Pessoa> pessoasEncontradas = pessoaRepository.buscarPorNome("Jessica");
        assertNotEquals(0, pessoasEncontradas.size());
    }

    private void adicionaPessoasLista(Pessoa p1, Pessoa p2, Pessoa p3, Pessoa p4){
        pessoaRepository.adicionaPessoa(p1);
        pessoaRepository.adicionaPessoa(p2);
        pessoaRepository.adicionaPessoa(p3);
        pessoaRepository.adicionaPessoa(p4);
    }
}
