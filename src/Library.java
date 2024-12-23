import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> livros;
    private ArrayList<User> usuarios;


    public Library(ArrayList<Book> livros, ArrayList<User> usuarios) {
        this.livros = livros;
        this.usuarios = usuarios;
    }

    public ArrayList<Book> getLivros() {
        return livros;
    }

    public ArrayList<User> getUsuarios() {
        return usuarios;
    }

    public void setLivros(ArrayList<Book> livros) {
        this.livros = livros;
    }

    public void setUsuarios(ArrayList<User> usuarios) {
        this.usuarios = usuarios;
    }

    public String cadastrarLivros() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o nome do livro a ser cadastrado");
        String scnTittle = scn.nextLine();

        System.out.println("Informe o nome do autor do livro a ser cadastrado");
        String scnAuth = scn.next();

        System.out.println("Informe o ID do livro a ser cadastrado");
        String scnId = scn.next();

        if (scnTittle == null || scnTittle.isEmpty() || scnTittle.isBlank()) {
            return "O titulo do livro é invalido!";
        } else if (scnAuth == null || scnAuth.isEmpty() || scnAuth.isBlank()) {
            return "O autor do livro é invalido!";
        } else if (scnId == null || scnId.isEmpty() || scnId.isBlank()) {
            return "O ID do livro é invalido";
        } else {
            Book livro = new Book(scnTittle, scnAuth, scnId, true);
            livros.add(livro);
            return "O livro foi cadastrado com sucesso!";
        }
    }

    public String cadastrarUsuario() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o nome do usuario a ser cadastrado");
        String scnNome = scn.nextLine();

        System.out.println("Informe o ID do usuario a ser cadastrado");
        int scnUserId = scn.nextInt();

        if (scnNome.isBlank()) {
            return "O nome de usuario é invalido!";
        } else if (scnUserId <= 0) {
            return "O id do usuario é invalido!";
        } else {
            User usuario = new User(scnNome, scnUserId, new ArrayList<>());
            usuarios.add(usuario);
            return "O usuario foi cadastrado com sucesso!";
        }

    }

    public String realizarEmprestimo() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o ISBN do livro: ");
        String scnISBN = scn.nextLine();

        System.out.println("Informe o ID do usuário que vai pegar o livro: ");
        int scnUserId = scn.nextInt();

        if (scnISBN == null || scnISBN.isBlank()) {
            return "O ISBN do livro é inválido!";
        }

        if (scnUserId <= 0) {
            return "O ID do usuário é inválido!";
        }

        Book livroEmprestar = null;
        for (Book livro : livros) {
            if (livro.getCodigoUnico().equals(scnISBN)) {
                livroEmprestar = livro;
                break;
            }
        }

        if (livroEmprestar == null) {
            return "Livro não encontrado!";
        }

        if (!livroEmprestar.isDisponivel()) {
            return "O livro não está disponível para empréstimo!";
        }

        User usuarioEmprestimo = null;
        for (User usuario : usuarios) {
            if (usuario.getId() == scnUserId) {
                usuarioEmprestimo = usuario;
                break;
            }
        }
        if (usuarioEmprestimo == null) {
            return "Usuário não encontrado!";
        }
        usuarioEmprestimo.getLivrosEmprestados().add(livroEmprestar.getCodigoUnico());
        livroEmprestar.setDisponivel(false);

        return "Empréstimo realizado com sucesso!";
    }
    public String exibirLivrosDisponiveis() {
        boolean temLivrosDisponiveis = false;

        for (Book livro : livros) {
            if (livro.isDisponivel()) {

                System.out.println("Título: " + livro.getTituloDoLivro() +
                        ", Autor: " + livro.getAutor() +
                        ", ISBN: " + livro.getCodigoUnico());
                temLivrosDisponiveis = true;
            }
        }

        if (!temLivrosDisponiveis) {
            return "Não há livros disponíveis para empréstimo!";
        }

        return "Livros exibidos com sucesso!";
    }

}