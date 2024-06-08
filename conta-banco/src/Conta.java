
public class Conta {
    private String numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public Conta(String numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return String.format("Olá %s, obrigado por criar uma conta em nosso banco! Sua agência é %s, conta %s e seu saldo %,.2f já está disponível para saque.",
                nomeCliente, agencia, numero, saldo);
    }
}
