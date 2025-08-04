public class contaImposto extends Conta {
    private double percentualImposto;

    public contaImposto(double saldoInicial, double percentualImposto) {
        super(saldoInicial);
        this.percentualImposto = percentualImposto;
    }

    public void calcularImposto() {
        double valorImposto = getSaldo() * percentualImposto / 100;
        sacar(valorImposto); // Subtrai o valor do imposto do saldo
    }

    public double getPercentualImposto() {
        return percentualImposto;
    }

    public void setPercentualImposto(double percentualImposto) {
        this.percentualImposto = percentualImposto;
    }

    // Método main para executar as operações
    public static void main(String[] args) {
        // Criando uma conta com saldo inicial e percentual de imposto
        contaImposto conta = new contaImposto(1000.0, 10.0);

        // Mostrando o saldo inicial
        System.out.println("Saldo inicial: " + conta.getSaldo());

        // Depositando dinheiro
        conta.depositar(500.0);
        System.out.println("Saldo após depósito: " + conta.getSaldo());

        // Sacando dinheiro
        conta.sacar(200.0);
        System.out.println("Saldo após saque: " + conta.getSaldo());

        // Calculando imposto
        conta.calcularImposto();
        System.out.println("Saldo após cálculo de imposto: " + conta.getSaldo());
    }
}