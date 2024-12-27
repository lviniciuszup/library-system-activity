import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library biblioteca = new Library(new ArrayList<>(), new ArrayList<>());
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\nBem-vindo ao Sistema de Gerenciamento de Biblioteca!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Realizar empréstimo");
            System.out.println("4. Realizar devolução");
            System.out.println("5. Exibir livros disponíveis");
            System.out.println("6. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    System.out.println(biblioteca.cadastrarLivro(titulo, autor, isbn));
                }
                case 2 -> {
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o ID do usuário:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(biblioteca.cadastrarUsuario(nome, id));
                }
                case 3 -> {
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    System.out.println("Digite o ID do usuário:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(biblioteca.realizarEmprestimo(isbn, id));
                }
                case 4 -> {
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    System.out.println("Digite o ID do usuário:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(biblioteca.realizarDevolucao(isbn, id));
                }
                case 5 -> System.out.println(biblioteca.exibirLivrosDisponiveis());
                case 6 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
