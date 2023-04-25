package codigo;

public class Serie {
    private int id;
    private String nome;
    private String genero;
    private String idioma;
    private int numVisualizacoes = 0;

    public Serie(int id, String nome, String genero, String idioma) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
    }

    public void atualizarNumVisualizacoes() {
        this.numVisualizacoes++;
    }

    public int getNumVisualizacoes() {
        return this.numVisualizacoes;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getIdioma() {
        return this.idioma;
    }
}
