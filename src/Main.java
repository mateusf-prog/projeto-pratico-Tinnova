import domain.Product;
import domain.Store;
import service.StoreService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Store store = new Store("Loja de 1,99");
        StoreService service = new StoreService(store);

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 5) {
            System.out.println("\n--- Bem vindo(a) a " + store.getName() + " ---");
            System.out.println("Opções disponíveis");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Listar produtos");
            System.out.println("4 - Buscar produto pelo nome");
            System.out.println("5 - Sair");

            System.out.print("\nDigite uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addProduct(service, scanner);
                    break;
                case 2:
                    removeProductByName(scanner, service);
                case 3:
                    findAllProducts(service);
                    break;
                case 4:
                    findByProductName(scanner, service);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }

    private static void findByProductName(Scanner scanner, StoreService service) {
        System.out.println("Digite o nome do produto:");
        String name = scanner.nextLine();
        Product product = service.getProductByName(name);
        System.out.println("\n\nProduto encontrado");
        System.out.println(product);
        System.out.println("\nDeseja buscar outro produto? (s/n)");
        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("s")) {
            findByProductName(scanner, service);
        } else {
            System.out.println("\nRetornando ao menu principal...\n\n");
        }
    }

    public static void addProduct(StoreService service, Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        String name = scanner.nextLine();
        System.out.println("Digite a quantidade do produto:");
        Integer quantity = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(name, quantity);
        service.addProduct(product);
        System.out.println("\nProduto adicionado com sucesso");
        System.out.println(product);
        System.out.println("\nDeseja adicionar outro produto? (s/n)");
        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("s")) {
            addProduct(service, scanner);
        } else {
            System.out.println("\nRetornando ao menu principal...\n\n");
        }
    }

    public static void removeProductByName(Scanner scanner, StoreService service) {

        System.out.println("Digite o nome do produto:");
        String name = scanner.nextLine();
        service.removeProductByName(name);
        System.out.println("\n\nProduto removido com sucesso");
        System.out.println("Deseja remover outro produto? (s/n)");
        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("s")) {
            removeProductByName(scanner, service);
        } else {
            System.out.println("\nRetornando ao menu principal...\n\n");
        }
    }

    public static void findAllProducts(StoreService service) {
        System.out.println("\n\nListando produtos...\n");
        service.getProducts().forEach(System.out::println);
        System.out.println("\nRetornando ao menu principal...\n\n");
    }
}
