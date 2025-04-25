import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() {
        for (ContaBancaria conta : contas) {
            conta.exibirResumo();
        }
    }

    public boolean contaJaExiste(String numeroConta, String titular) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta) || conta.getTitular().equalsIgnoreCase(titular)) {
                return true;
            }
        }
        return false;
    }
}
