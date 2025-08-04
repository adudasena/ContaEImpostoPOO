import org.junit.Test;

import static org.junit.Assert.assertEquals;

    public class TesteConta {

        @Test
        public void testSaldoInicial() {
            contaImposto conta = new contaImposto(1000.0, 10.0);
            assertEquals(1000.0, conta.getSaldo(), 0.001);
            }

        @Test
        public void testSaque() {
            contaImposto conta = new contaImposto(1000.0, 10.0);
            conta.sacar(200.0);
            assertEquals(800.0, conta.getSaldo(), 0.001);
        }

        @Test
        public void testDeposito() {
            contaImposto conta = new contaImposto(1000.0, 10.0);
            conta.depositar(500.0);
            assertEquals(1500.0, conta.getSaldo(), 0.001);
        }

        @Test
        public void testCalcularImposto() {
            contaImposto conta = new contaImposto(1000.0, 10.0);
            conta.calcularImposto();
            assertEquals(900.0, conta.getSaldo(), 0.001); // 1000 - 10% de 1000
        }

        @Test
        public void testPercentualImpostoMenor() {
            contaImposto conta = new contaImposto(2000.0, 2.5);
            assertEquals(2.5, conta.getPercentualImposto(), 0.001);
        }

        @Test
        public void testDepositoNegativo() {
            contaImposto conta = new contaImposto(1000.0, 10.0);
            conta.depositar(-500.0);
            assertEquals(1000.0, conta.getSaldo(), 0.001); // Saldo não deve mudar
        }

        @Test
        public void testSaqueIgualAoSaldo() {
            contaImposto conta = new contaImposto(2500.0, 3.0);
            conta.sacar(2500.0);
            assertEquals(0.0, conta.getSaldo(), 0.001);
        }

        @Test
        public void testSaqueAcimaDoSaldo() {
            contaImposto conta = new contaImposto(1000.0, 10.0);
            conta.sacar(1500.0);
            assertEquals(1000.0, conta.getSaldo(), 0.001); // Saldo não deve mudar
        }

        @Test
        public void testCalcularImpostoAposSaque() {
            contaImposto conta = new contaImposto(1000.0, 10.0);
            conta.sacar(300.0);
            conta.calcularImposto();
            assertEquals(630.0, conta.getSaldo(), 0.001); // 700 - 10% de 700
        }

        @Test
        public void testCalcularImpostoAposDeposito() {
            contaImposto conta = new contaImposto(1000.0, 10.0);
            conta.depositar(500.0);
            conta.calcularImposto();
            assertEquals(1350.0, conta.getSaldo(), 0.001); // 1500 - 10% de 1500
        }
    }
