package uninter;
import java.util.Scanner;

public class Menu {

    private Scanner sc;
    private Cofrinho cofrinho;

    public Menu() {
        sc = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }


    public void exibirMenuPrincipal() {
        System.out.println("Cofrinho:");
        System.out.println("1-Adicionar Moeda");
        System.out.println("2-Remover moeda");
        System.out.println("3-Listar moedas");
        System.out.println("4-Calcular valor convertido para real");
        System.out.println("0-Encerrar:");

        String opcaoSelecionada = sc.next();

        switch(opcaoSelecionada) {
        case "0":
            System.out.println("Sistema encerrado!");
            break;
            
        case"1":
        	exibirSubMenuAdicionarMoedas();
            exibirMenuPrincipal();
            break;
            
        case"2":
        	exibirSubMenuRemoverMoedas();
            exibirMenuPrincipal();
            break;
            
        case "3":
        	cofrinho.listagemMoedas();
        	exibirMenuPrincipal();     	
        	break;
        	
        case "4":
        	double valorTotalConvertido = cofrinho.totalConvertido();
        	String valorTotalConvertidoTextual = String.format("%.2f", valorTotalConvertido);
        	valorTotalConvertidoTextual = valorTotalConvertidoTextual.replace(".", ",");
        	System.out.println("O valor convertido para Real é: R$ " + valorTotalConvertidoTextual + ".");

        	exibirMenuPrincipal();
        	break;

        default:
            System.out.println("Opção Inválida!");
            exibirMenuPrincipal();
            break;
        }
    }
    
    private void exibirSubMenuAdicionarMoedas() {
        System.out.println("Escolha a sua moeda:");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");

        int opcaoMoeda = sc.nextInt();

        System.out.println("Digite o valor: ");
        String valorTextualMoeda = sc.next();

        valorTextualMoeda = valorTextualMoeda.replace(",", ".");
        double valorMoeda = Double.parseDouble(valorTextualMoeda);

        Moeda moeda = null;

        if (opcaoMoeda == 1) {
            moeda = new Real(valorMoeda);
        } else if (opcaoMoeda == 2) {
            moeda = new Dolar(valorMoeda);
        } else if (opcaoMoeda == 3) {
            moeda = new Euro(valorMoeda);
        } else {
            System.out.println("Não existe esta opção!");
            exibirMenuPrincipal();
        }

        cofrinho.adicionar(moeda);
        System.out.println("Moeda adicionada!");
    }
    
    private void exibirSubMenuRemoverMoedas() {
        System.out.println("Escolha a sua moeda:");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");

        int opcaoMoeda = sc.nextInt();

        System.out.println("Digite o valor: ");
        String valorTextualMoeda = sc.next();

        valorTextualMoeda = valorTextualMoeda.replace(",", ".");
        double valorMoeda = Double.parseDouble(valorTextualMoeda);

        Moeda moeda = null;

        if (opcaoMoeda == 1) {
            moeda = new Real(valorMoeda);
        } else if (opcaoMoeda == 2) {
            moeda = new Dolar(valorMoeda);
        } else if (opcaoMoeda == 3) {
            moeda = new Euro(valorMoeda);
        } else {
            System.out.println("Não existe esta opção!");
            exibirMenuPrincipal();
        }
        
        boolean removeuMoeda = cofrinho.remover(moeda);

        if (removeuMoeda) {
        	System.out.println("A opção de remover moeda foi executada com sucesso!");
        } else {
        	System.out.println("A moeda não foi encontrada!");
        }
        
    }


}
