package TAA;

public class Livros {
    private String livro;
    private String de_ip;
    private int contador = 1;
    private static int pro_contador = 1;

    public Livros(String livro, String de_ip) {
        this.livro = livro;
        this.de_ip = de_ip;
        this.contador = pro_contador;
        pro_contador++;
    }

    public String getLivro() {
        return livro;
    }

    public String getDe_ip() {
        return de_ip;
    }

    public int getContador() {
        return contador;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public void setDe_ip(String de_ip) {
        this.de_ip = de_ip;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "Livros{" + "livro=" + livro + ", de_ip=" + de_ip + ", contador=" + contador + '}';
    }
}
