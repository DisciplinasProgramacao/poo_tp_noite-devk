package codigo;

public abstract class Conteudo {
    protected int id;
    protected String nome;
    protected String genero;
    protected String idioma;
    protected int numVisualizacoes = 0;
    protected long mediaAvaliacoes = 0;
    protected int numAvaliacoes = 0;
    protected String dataLancamento;

    public String getGenero() {
        return this.genero;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public String getNome() {
        return this.nome;
    }
}
