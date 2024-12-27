import java.util.ArrayList;

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

    public String cadastrarLivro(String titulo, String autor, String isbn) {
        if (titulo == null || titulo.isBlank()) {
            return "O título do livro é inválido!";
        }
        if (autor == null || autor.isBlank()) {
            return "O autor do livro é inválido!";
        }
        if (isbn == null || isbn.isBlank()) {
            return "O ISBN do livro é inválido!";
        }

        Book livro = new Book(titulo, autor, isbn, true);
        livros.add(livro);
        return "O livro foi cadastrado com sucesso!";
    }

    public String cadastrarUsuario(String nome, int id) {
        if (nome == null || nome.isBlank()) {
            return "O nome do usuário é inválido!";
        }
        if (id <= 0) {
            return "O ID do usuário é inválido!";
        }

        User usuario = new User(nome, id, new ArrayList<>());
        usuarios.add(usuario);
        return "O usuário foi cadastrado com sucesso!";
    }

    public String realizarEmprestimo(String isbn, int userId) {
        Book livro = buscarLivroPorISBN(isbn);
        if (livro == null) {
            return "Livro não encontrado!";
        }
        if (!livro.isDisponivel()) {
            return "O livro não está disponível para empréstimo!";
        }

        User usuario = buscarUsuarioPorId(userId);
        if (usuario == null) {
            return "Usuário não encontrado!";
        }

        usuario.getLivrosEmprestados().add(livro.getCodigoUnico());
        livro.setDisponivel(false);
        return "Empréstimo realizado com sucesso!";
    }

    public String realizarDevolucao(String isbn, int userId) {
        Book livro = buscarLivroPorISBN(isbn);
        if (livro == null) {
            return "Livro não encontrado!";
        }

        User usuario = buscarUsuarioPorId(userId);
        if (usuario == null) {
            return "Usuário não encontrado!";
        }

        if (!usuario.getLivrosEmprestados().contains(isbn)) {
            return "O usuário não possui este livro emprestado!";
        }

        usuario.getLivrosEmprestados().remove(isbn);
        livro.setDisponivel(true);
        return "Devolução realizada com sucesso!";
    }

    public String exibirLivrosDisponiveis() {
        StringBuilder livrosDisponiveis = new StringBuilder();
        for (Book livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.append(livro.exibirDetalhes()).append("\n");
            }
        }

        return livrosDisponiveis.length() > 0 ? livrosDisponiveis.toString() : "Não há livros disponíveis!";
    }

    private Book buscarLivroPorISBN(String isbn) {
        for (Book livro : livros) {
            if (livro.getCodigoUnico().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    private User buscarUsuarioPorId(int id) {
        for (User usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}
