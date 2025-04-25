import java.util.Scanner;

public class AplicacaoBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        System.out.print("Quantas contas deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nCadastro da conta " + (i + 1));
            System.out.print("Número da conta: ");
            String numeroConta = scanner.nextLine();

            System.out.print("Nome do titular: ");
            String titular = scanner.nextLine();

            ContaBancaria novaConta = new ContaBancaria(numeroConta, titular);
            banco.adicionarConta(novaConta);
        }

        int opcao;
        while (true) {
            System.out.println("\nMenu - O que deseja fazer?");
            System.out.println("1 - Acessar conta");
            System.out.println("2 - Cadastrar nova conta");
            System.out.println("3 - Ver resumo de todas as contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;

                case 1:
                    System.out.print("Digite o número da conta: ");
                    String numeroBusca = scanner.nextLine();
                    ContaBancaria conta = banco.buscarConta(numeroBusca);

                    if (conta != null) {
                        acessarConta(scanner, conta);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 2:
                    System.out.print("Número da nova conta: ");
                    String novaContaNum = scanner.nextLine();
                    System.out.print("Nome do titular: ");
                    String novoTitular = scanner.nextLine();

                    if (banco.contaJaExiste(novaContaNum, novoTitular)) {
                        System.out.println("Erro: Já existe uma conta com esse número ou titular.");
                    } else {
                        ContaBancaria novaConta = new ContaBancaria(novaContaNum, novoTitular);
                        banco.adicionarConta(novaConta);
                        System.out.println("Conta cadastrada com sucesso!");
                    }
                    break;

                case 3:
                    banco.listarContas();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("(Pressione Enter para continuar.)");
            scanner.nextLine();
        }
    }

    public static void acessarConta(Scanner scanner, ContaBancaria conta) {
        int opcao;
        double valor;

        while (true) {
            System.out.println("\nBem-vindo, " + conta.getTitular() + ". O que deseja fazer?");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0:
                    return;

                case 1:
                    conta.exibirResumo();
                    break;

                case 2:
                    System.out.print("Digite o valor do saque: ");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Confirmar saque de R$" + valor + "? (S/N): ");
                    if (scanner.nextLine().equalsIgnoreCase("S")) {
                        conta.sacar(valor);
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor do depósito: ");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Confirmar depósito de R$" + valor + "? (S/N): ");
                    if (scanner.nextLine().equalsIgnoreCase("S")) {
                        conta.depositar(valor);
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("(Pressione Enter para continuar.)");
            scanner.nextLine();
        }
    }
}
