import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opc = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = sc.nextDouble();

        List<Compra> compras = new ArrayList<>();
        while(limite > 0 & opc ==  1){
            System.out.println("Digite a descrição da compra: ");
            String descricao = sc.next();
            System.out.println("Digite o valor da compra: ");
            double valor = sc.nextDouble();

            if(valor <= limite){
                Compra compra = new Compra();
                compra.setDescricao(descricao);
                compra.setValor(valor);
                limite -= valor;
                compras.add(compra);
                System.out.println("Compra Realizada!");
            } else {
                System.out.println("Saldo Insuficiente!");
                break;
            }

            if(limite > 0 ) {
                System.out.println("Digite 0 para sair ou 1 para continuar: ");
                opc = sc.nextInt();
                if(opc == 0){
                    break;
                }
            }

        }

        compras.sort(Comparator.comparing(Compra::getValor));
        System.out.println("\n********************");
        System.out.println("COMPRAS REALIZADAS: \n");
        for(Compra item : compras){
            System.out.println(item);
        }
        System.out.println("\n********************");
        System.out.println("\nSaldo do cartão R$: " + limite);

    }
}