import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Digite o nome do titular:");
        double saldoInicial = Double.parseDouble(
                JOptionPane.showInputDialog("Digite o saldo inicial:")
        );

        ContaBancaria conta = new ContaBancaria(nome, saldoInicial);

        int opcao;

        do {
            String menu = """
                    === MENU ===
                    1 - Depositar
                    2 - Sacar
                    3 - Ver Saldo
                    4 - Sair
                    """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {

                case 1:
                    double deposito = Double.parseDouble(
                            JOptionPane.showInputDialog("Valor para depósito:")
                    );
                    conta.depositar(deposito);
                    JOptionPane.showMessageDialog(null, "Depósito realizado!");
                    break;

                case 2:
                    double saque = Double.parseDouble(
                            JOptionPane.showInputDialog("Valor para saque:")
                    );

                    if (conta.sacar(saque)) {
                        JOptionPane.showMessageDialog(null, "Saque realizado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Titular: " + conta.getTitular() +
                            "\nSaldo: R$ " + conta.getSaldo());
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Encerrando sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 4);
    }
}
