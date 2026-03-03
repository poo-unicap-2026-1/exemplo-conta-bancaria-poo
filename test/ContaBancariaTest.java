import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    void deveDepositarCorretamente() {
        ContaBancaria conta = new ContaBancaria("Ivna", 100);
        conta.depositar(50);

        assertEquals(150, conta.getSaldo());
    }

    @Test
    void naoDevePermitirSaqueMaiorQueSaldo() {
        ContaBancaria conta = new ContaBancaria("Ivna", 100);
        boolean resultado = conta.sacar(200);

        assertFalse(resultado);
        assertEquals(100, conta.getSaldo());
    }
}