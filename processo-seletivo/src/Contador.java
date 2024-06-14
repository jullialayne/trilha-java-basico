import java.util.InputMismatchException;
import java.util.Scanner;

class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String mensagem) {
        super(mensagem);
    }
}

public class Contador {

    private static final String MENSAGEM_ERRO_PARAMETROS_INVALIDOS = "O segundo parametro deve ser maior que o primeiro";

    public static void main(String[] args) {
        try (Scanner terminal = new Scanner(System.in)) {
            int parametroUm = obterParametro("Digite o primeiro parametro", terminal);
            int parametroDois = obterParametro("Digite o segundo parametro", terminal);

            try {
                contar(parametroUm, parametroDois);

            } catch (ParametrosInvalidosException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static int obterParametro(String mensagem, Scanner scanner) {
        int parametro = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println(mensagem);
            try {
                parametro = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um numero inteiro valido.");
                scanner.next(); 
            }
        }
        return parametro;
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        validarParametros(parametroUm, parametroDois);

        int contagem = parametroDois - parametroUm;
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o numero "+i);
        }
    }

    static void validarParametros(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm >= parametroDois) {
            throw new ParametrosInvalidosException(MENSAGEM_ERRO_PARAMETROS_INVALIDOS);
        }
    }
}
