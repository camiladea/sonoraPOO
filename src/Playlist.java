import java.util.ArrayList;

public class Playlist {
    private String nome;
    private Usuario dono;
    private ArrayList<Conteudo> conteudos; 

    public Playlist(String nome, Usuario dono) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da playlist nao pode ser vazio.");
        }
        if (dono == null) {
            throw new IllegalArgumentException("A playlist precisa de um dono valido.");
        }

        this.nome = nome;
        this.dono = dono;
        this.conteudos = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public Usuario getDono() { return dono; }
    public int getQuantidade() { return conteudos.size(); }

    public boolean adicionar(Conteudo conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("Nao e possivel adicionar conteudo nulo.");
        }
        conteudos.add(conteudo);
        return true;
    }

    public Conteudo getNaPosicao(int indice) {
        if (indice < 0 || indice >= conteudos.size()) {
            throw new IndexOutOfBoundsException("Posicao invalida na playlist: " + indice);
        }
        return conteudos.get(indice);
    }

    public boolean removerNaPosicao(int indice) {
        if (indice < 0 || indice >= conteudos.size()) {
            throw new IndexOutOfBoundsException("Posicao invalida: " + indice);
        }
        conteudos.remove(indice);
        return true;
    }

    public int getDuracaoTotalSegundos() {
        int soma = 0;
        for (Conteudo c : conteudos) {
            soma += c.getDuracaoSegundos();
        }
        return soma;
    }

    public void reproduzirTudo() {
        for (Conteudo c : conteudos) {
            c.reproduzir(); 
        }
    }
}