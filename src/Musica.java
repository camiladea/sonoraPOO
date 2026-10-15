public class Musica extends Conteudo {
    private String artista;
    private String album;

    public Musica(String titulo, int duracaoSegundos, String artista, String album) {
        super(titulo, duracaoSegundos);
        setArtista(artista);
        setAlbum(album);
    }

    public String getArtista() { return artista; }
    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) throw new IllegalArgumentException("Artista nao pode ser vazio.");
        this.artista = artista;
    }

    public String getAlbum() { return album; }
    public void setAlbum(String album) {
        if (album == null || album.trim().isEmpty()) throw new IllegalArgumentException("Album nao pode ser vazio.");
        this.album = album;
    }

    @Override
    public String getCreditos() {
        return artista + " (" + album + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + getCreditos();
    }
}