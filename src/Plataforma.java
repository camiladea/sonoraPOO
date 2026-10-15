import java.util.ArrayList;

public class Plataforma {
    private ArrayList<Conteudo> acervo; 
    private ArrayList<Usuario> usuarios;
    private ArrayList<Anuncio> anuncios; 

    public Plataforma() {
        this.acervo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.anuncios = new ArrayList<>();
    }

    public boolean cadastrarConteudo(Conteudo conteudo) {
        if (conteudo == null) return false;
        acervo.add(conteudo);
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null) return false;
        usuarios.add(usuario);
        return true;
    }

    public boolean cadastrarAnuncio(Anuncio anuncio) {
        if (anuncio == null) return false;
        anuncios.add(anuncio);
        return true;
    }

    public Conteudo buscarConteudo(int id) {
        for (Conteudo c : acervo) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public void listarEpisodiosDe(String apresentador) {
        System.out.println("Episodios encontrados de " + apresentador + ":");
        for (Conteudo c : acervo) {
            if (c instanceof Podcast) {
                Podcast p = (Podcast) c; // Downcasting
                if (p.getApresentador().equalsIgnoreCase(apresentador)) {
                    System.out.println(p.toString());
                }
            }
        }
    }

    public double calcularReceitaMensal() {
        ArrayList<Faturavel> faturaveis = new ArrayList<>();
        
        for (Usuario u : usuarios) {
            faturaveis.add(u.getPlano());
        }
        for (Anuncio a : anuncios) {
            faturaveis.add(a);
        }
        
        double total = 0;
        for (Faturavel item : faturaveis) {
            total += item.calcularMensalidade(); 
        }
        
        return total;
    }

    public int getTotalConteudos() { return acervo.size(); }
    public int getTotalUsuarios() { return usuarios.size(); }
}