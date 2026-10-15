import java.util.ArrayList;

public class Usuario {
    private static int contadorId = 1;
    
    private int id;
    private String nome;
    private String email;
    private ArrayList<Usuario> seguindo;
    private Plano plano;

    public Usuario(String nome, String email) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome nao pode ser vazio.");
        if (email == null || email.trim().isEmpty() || !email.contains("@")) throw new IllegalArgumentException("Email invalido.");

        this.id = contadorId++;
        this.nome = nome;
        this.email = email;
        this.seguindo = new ArrayList<>();
        this.plano = new PlanoGratuito(); 
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public Plano getPlano() { return plano; }

    public void assinar(Plano novoPlano) {
        if (novoPlano == null) {
            throw new IllegalArgumentException("O plano escolhido nao pode ser nulo.");
        }
        this.plano = novoPlano;
    }

    public boolean seguir(Usuario outro) { /* ... */ return true; }
    public boolean deixarDeSeguir(Usuario outro) { /* ... */ return true; }
}