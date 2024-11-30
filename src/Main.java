import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nameClient = "Cristian Santos";
        String accountNumber = "123456789";
        double balance = 2500.00;

        Locale brazil = new Locale("pt", "BR");
        Currency currency = Currency.getInstance(brazil);

        System.out.println("Bem vindo ao BankIt\n\n*******************************\nDados iniciais do cliente:\n\nNome: " + nameClient + "\n" + "Número da conta: " + accountNumber + "\n" + "Saldo: " + currency.getSymbol() + balance + "\n" + "*******************************\n");

        System.out.println("Digite a opção desejada");
        String menuOptions = """
                1 - Verificar saldo
                2 - Depositar
                3 - Transferir
                4 - Sair
                """;
        System.out.println(menuOptions);
        int options = 0;

        while (options != 4) {
            options = input.nextInt();
            if (options == 1) {
                System.out.println("Seu saldo atual é : " + currency.getSymbol() + balance);
            } else if (options == 2) {
                System.out.println("Digite o valor que deseja depositar: ");
                double deposit = input.nextDouble();
                balance += deposit;
                System.out.println("Depósito realizado com sucesso! Seu saldo atual é: " + currency.getSymbol() + balance);
            } else if (options == 3) {
                System.out.println("Digite o valor que deseja transferir: ");
                double transfer = input.nextDouble();
                if (transfer > balance) {
                    System.out.println("Saldo insuficiente para realizar a transferência");
                } else {
                    balance -= transfer;
                    System.out.println("Transferência realizada com sucesso! Seu saldo atual é: " + currency.getSymbol() + balance);
                }
            }
            if (options == 4) {
                System.out.println("Obrigado por utilizar o BankIt! Volte sempre.");
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}