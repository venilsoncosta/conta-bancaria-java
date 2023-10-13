import java.util.Date;

public class ContaBancaria {
    private String nome;
    private String agencia;
    private String numeroConta;
    private Date dataAberturaConta;
    private double saldo;

    public ContaBancaria(String nome, String agencia, String numeroConta, double saldo) {
        if(agencia != null && agencia.length() == 4 && numeroConta != null && numeroConta.length() == 6){
            this.nome = nome;
            this.agencia = agencia;
            this.numeroConta = numeroConta;
            this.saldo = saldo;
            this.dataAberturaConta = new Date();
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Você depositou R$" + valor);
        System.out.println("Seu saldo atual é R$" + getSaldo());
    }

    public void sacar(double valor){
        if(this.saldo < valor){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;
        System.out.println("Você realizou um saque no valor de R$" + valor);
        System.out.println("Seu saldo atual é de R$" + getSaldo());
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "nome: '" + nome + '\'' +
                ", agencia: " + agencia +
                ", numeroConta: " + numeroConta +
                ", saldo: " + saldo +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Date getDataAberturaConta() {
        return dataAberturaConta;
    }
}
