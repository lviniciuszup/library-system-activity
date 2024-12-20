public class Book {
    private String tituloDoLivro;
    private String autor;
    private String codigoUnico;
    private boolean disponivel;

    public exibirDetalhes(String tituloDoLivro, String autor, String codigoUnico){
        this.tituloDoLivro = tituloDoLivro;
        this.autor = autor;
        this.codigoUnico = codigoUnico;
    }
    public String getTituloDoLivro(){
        return tituloDoLivro;
    }
    public String getAutor(){
        return autor;
    }
    public String getCodigoUnico(){
        return autor;
    }
    public emprestar(boolean disponivel){
        this.disponivel = true;
    }
    public boolean getDisponivel(){
        return true;
    }
    public devolver(boolean devolver){
        this.disponivel = false;
    }
    public boolean getDevolver(){
        return false;
    }
}
