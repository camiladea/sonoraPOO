public class Anuncio implements Faturavel {
    private String anunciante;
    private String titulo;
    private int duracaoSegundos;
    private double valorPorMilImpressoes;
    private int impressoes;

    public Anuncio(String anunciante, String titulo, int duracaoSegundos, double valorPorMilImpressoes) {
        if (anunciante == null || anunciante.trim().isEmpty()) {
            throw new IllegalArgumentException("O anunciante nao pode ser vazio.");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O titulo nao pode ser vazio.");
        }
        if (duracaoSegundos <= 0) {
            throw new IllegalArgumentException("A duracao deve ser maior que zero.");
        }
        if (valorPorMilImpressoes <= 0) {
            throw new IllegalArgumentException("O valor por mil impressoes deve ser maior que zero.");
        }

        this.anunciante = anunciante;
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.valorPorMilImpressoes = valorPorMilImpressoes;
        this.impressoes = 0; // Comeca em zero
    }

    public int getImpressoes() {
        return impressoes;
    }

    public void reproduzir() {
        impressoes++;
        System.out.println("[Anuncio] " + titulo + " - oferecimento de " + anunciante);
    }

    @Override
    public double calcularMensalidade() {
        return (impressoes / 1000.0) * valorPorMilImpressoes;
    }
}