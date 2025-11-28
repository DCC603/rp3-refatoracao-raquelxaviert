import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private Agencia agencia;
    private double saldo;

    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double saldo) {
        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.agencia = new Agencia(numAgencia, numConta, gerente);
        this.saldo = saldo;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    public void realizarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);
        atualizarSaldo(tipo, valor);
    }

    private void atualizarSaldo(char tipo, int valor) {
        if (tipo == 'd')
            this.saldo += valor;
        else if(tipo == 's')
            this.saldo -= valor;
    }

    public String toString() {
        return "-----CLIENTE-----\n" +
                getDadosCliente() +
                "\n\n" +
                "-----CONTA-----\n" +
                getDadosConta() +
                "\n\n" +
                "-----EXTRATO-----\n" +
                getExtrato() +
                "\n";
    }

    private String getDadosCliente() {
        return cliente.toString();
    }

    private String getDadosConta() {
        return agencia.toString() + String.format("\nSaldo: %.2f", saldo);
    }

    private String getExtrato() {
        String extrato = "";
        for(Operacao op : operacoes) {
            extrato += op.toString() + "\n";
        }
        return extrato;
    }
}
