public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("Venilson", "1234", "123456", 0);
        System.out.println(conta1.getNumeroConta());
        conta1.depositar(342);
        conta1.sacar(18);


    }
}