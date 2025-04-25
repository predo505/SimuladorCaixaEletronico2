public class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        setTitular(titular);
        this.saldo = 0.0;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String novoTitular) {
        if (novoTitular != null && !novoTitular.trim().equals("")) {
            this.titular = novoTitular;
        } else {
            System.out.println("Nome do titular inválido.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Só é permitido depositar valores positivos.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saque não permitido. Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public void exibirResumo() {
        System.out.println("Conta: " + numeroConta + " - Titular: " + titular + " - Saldo: R$ " + String.format("%.2f", saldo));
    }
}
