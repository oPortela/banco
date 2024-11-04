package banco;

public class ContaNormal extends Conta {
    public void creditar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor para crédito deve ser positivo.");
        }
    }

    public void debitar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else {
            saldo -= valor;
        }
    }
}
