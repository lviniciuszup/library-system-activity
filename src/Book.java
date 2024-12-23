public class Book {
    private String tituloDoLivro;
    private String autor;
    private String codigoUnico;
    private boolean disponivel;

    public Book(String tituloDoLivro, String autor, String codigoUnico, boolean disponivel) {
        this.tituloDoLivro = tituloDoLivro;
        this.autor = autor;
        this.codigoUnico = codigoUnico;
        this.disponivel = disponivel;
    }

    public String exibirDetalhes(){
        return "livro: " + this.tituloDoLivro + " autor: " + this.autor + " codigo: " + this.codigoUnico +" disponivel: " +this.disponivel;
    }
    public String getTituloDoLivro(){
        return tituloDoLivro;
    }
    public String getAutor(){
        return autor;
    }
    public String getCodigoUnico(){
        return codigoUnico;
    }
    public void emprestar(){
        this.disponivel = false;
    }
    public void devolver(){this.disponivel = true;    }

    public void setTituloDoLivro(String tituloDoLivro) {
        this.tituloDoLivro = tituloDoLivro;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
