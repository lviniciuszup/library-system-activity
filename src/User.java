import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class User {
    private String nome;
    private int id;
    private ArrayList<String> livrosEmprestados;

    public User(String nome, int id, ArrayList<String> livrosEmprestados) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = livrosEmprestados;
    }

    public String exibirDetalhes() {
        return "Nome do usuário: " + nome + " Id: " + id + " Livros emprestados: " + livrosEmprestados;
    }

    public String adicionarLivro(String tituloDoLivro) {
        if (livrosEmprestados.contains(tituloDoLivro)) {
            return "O livro ja está na lista de emprestados!";
        } else {
            livrosEmprestados.add(tituloDoLivro);
            return "O livro foi adicionado a lista de emprestados!";
        }
    }

    public String removerLivro(String tituloDoLivro) {
        if (livrosEmprestados.contains(tituloDoLivro)) {
            livrosEmprestados.remove(tituloDoLivro);
            return "O livro foi removido da lista de emprestados!";
        } else {
            return "O livro não está na lista de emprestados!";
        }
    }

        public String getNome() {
            return nome;
        }
        public int getId () {
            return id;
        }
        public ArrayList<String> getLivrosEmprestados () {
            return livrosEmprestados;
        }

        public void setNome (String nome){
            this.nome = nome;
        }
        public void setId ( int id){
            this.id = id;
        }

        public void setLivrosEmprestados(ArrayList <String> livrosEmprestados) {
            this.livrosEmprestados = livrosEmprestados;
        }
    }