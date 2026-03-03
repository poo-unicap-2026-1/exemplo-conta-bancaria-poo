import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistema Bancário ===");

        System.out.print("Digite o nome do titular: ");
        String nome = sc.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, saldoInicial);

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depósito: ");
                    double deposito = sc.nextDouble();
                    conta.depositar(deposito);
                    System.out.println("Depósito realizado!");
                    break;

                case 2:
                    System.out.print("Valor para saque: ");
                    double saque = sc.nextDouble();
                    if (conta.sacar(saque)) {
                        System.out.println("Saque realizado!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;

                case 3:
                    System.out.println("Titular: " + conta.getTitular());
                    System.out.println("Saldo: R$ " + conta.getSaldo());
                    break;

                case 4:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        sc.close();
    }
}