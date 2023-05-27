import java.util.*;

public class Main {
    public static void main(String[] args) {
        int sair = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = sc.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        while(sair !=  0){
            System.out.println("Digite a descrição da compra: ");
            String descricao = sc.next();

            System.out.println("Digite o valor da compra: ");
            double valor = sc.nextDouble();

           Compra compra = new Compra(descricao, valor);
           boolean compraRealizada = cartao.lancaCompra(compra);
           if(compraRealizada){
               System.out.println("Compra realizada!");
               System.out.println("Digite 0 para sair ou 1 para continuar");
               sair = sc.nextInt();
           } else {
               System.out.println("Saldo insuficiente!");
               sair = 0;
           }

        }

        Collections.sort(cartao.getCompras());
        System.out.println("\n********************");
        System.out.println("COMPRAS REALIZADAS: \n");
        for(Compra item : cartao.getCompras()){
            System.out.println(item);
        }
        System.out.println("\n********************");
        System.out.println("\nSaldo do cartão R$: " + cartao.getSaldo());

    }
}