import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        // Configurar a saída para UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String numero, agencia, nomeCliente;
        double saldo;

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());

        System.out.println("Por favor, digite o número da conta:");
        numero = scanner.nextLine();

        System.out.println("Por favor, digite o número da agência:");
        agencia = scanner.nextLine();

        System.out.println("Por favor, digite o seu nome:");
        nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o saldo:");
        while (true) {
            if (scanner.hasNextDouble()) {
                saldo = scanner.nextDouble();
                if (saldo >= 0) {
                    break;
                } else {
                    System.out.println("O saldo não pode ser negativo. Por favor, digite um valor válido:");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um valor numérico:");
                scanner.next(); // Limpar a entrada inválida
            }
        }

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco! Sua agência é %s, conta %s e seu saldo %.2f já está disponível para saque.%n", 
                          nomeCliente, agencia, numero, saldo);

        scanner.close();
    }
}
