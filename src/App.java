import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();

        Conteudo c = new Podcast("FlowCast", 7200, "Igor", 5);
        
       

        System.out.println("=== Demonstracao de Polimorfismo e Interfaces ===");
        
        plataforma.cadastrarConteudo(c); // c e um podcast
        plataforma.cadastrarConteudo(new Musica("Tempo Perdido", 300, "Legiao Urbana", "Dois"));
        plataforma.cadastrarConteudo(new Podcast("DevCast", 5400, "Felipe", 42));
        
        Usuario u1 = new Usuario("Andre", "andre@teste.com");
        u1.assinar(new PlanoIndividual(19.90));
        plataforma.cadastrarUsuario(u1);
        
        Usuario u2 = new Usuario("Maria", "maria@teste.com");
        u2.assinar(new PlanoFamilia(29.90, 4));
        plataforma.cadastrarUsuario(u2);
        
        Anuncio a1 = new Anuncio("Torrefacao Serrana", "Cafe da Serra", 15, 50.0);
        plataforma.cadastrarAnuncio(a1);

        for (int i = 0; i < 3000; i++) {
            a1.reproduzir(); 
        }

        System.out.println("\n--- Buscando Episodios ---");
        plataforma.listarEpisodiosDe("Felipe");

        System.out.println("\n--- Fechamento Financeiro ---");
        System.out.println("Receita Mensal Total (Planos + Anuncios): R$ " + plataforma.calcularReceitaMensal());

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== Sonora - Fase Interfaces ===");
            System.out.println("1 - Ver receita total do mes");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero.");
                continue;
            }

            if (opcao == 1) {
                System.out.println("R$ " + plataforma.calcularReceitaMensal());
            } else if (opcao == 0) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }
}