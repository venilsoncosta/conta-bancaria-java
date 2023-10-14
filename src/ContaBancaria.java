import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaBancaria {
    private String nome;
    private String agencia;
    private String numeroConta;
    private Date dataAberturaConta;
    private double saldo;
    private final List<Date> datasDepositos = new ArrayList<>();
    private final List<Date> dataSaques = new ArrayList<>();
    private final List<Date> dataTransferencia = new ArrayList<>();

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
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido para depósito");
        }
        this.saldo += valor;
        datasDepositos.add(new Date());
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar(double valor){
        if(this.saldo < valor || valor <= 0){
            throw new IllegalArgumentException("Não foi possível realizar o saque.");
        }
        this.saldo -= valor;
        dataSaques.add(new Date());
        System.out.println("Saque realidazo com sucesso!");
    }
    public void transferir(ContaBancaria outraConta, double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido para transferência");
        }
        this.sacar(valor);
        outraConta.depositar(valor);
        dataTransferencia.add(new Date());
        System.out.println("Transferência realizada com sucesso!");
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

    public List<Date> getDatasDepositos() {
        return datasDepositos;
    }

    public List<Date> getDataSaques() {
        return dataSaques;
    }

    public List<Date> getDataTransferencia() {
        return dataTransferencia;
    }
}
