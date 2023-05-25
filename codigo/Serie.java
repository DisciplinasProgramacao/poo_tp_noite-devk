package codigo;

public class Serie {
    private int id;
    private String nome;
    private String genero;
    private String idioma;
    private int numVisualizacoes = 0;
    private long mediaAvaliacoes = 0;
    private int numAvaliacoes = 0;
    private int qtdEpisodios = 0;

    //Construtor da classe Serie:
    public Serie(int id, String nome, String genero, String idioma, int qtdEpisodios){
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
        this.qtdEpisodios = qtdEpisodios;
    }

    //Se tiver avaliaçao incrementa a quantidade
    public void avaliarMidia(int notaAvaliacao) {
        if (notaAvaliacao < Avaliacao.NOTA_MIN_AVALIACAO || notaAvaliacao > Avaliacao.NOTA_MAX_AVALIACAO) {
            return;
        }
        numAvaliacoes++;
        recalcularAvaliacaoMedia(notaAvaliacao);
    }

    //Soma as notas e divide pela quantidade = Média de avaliações
    private void recalcularAvaliacaoMedia(int notaNovaAvaliacao) {
        this.mediaAvaliacoes = this.mediaAvaliacoes + ((notaNovaAvaliacao- this.mediaAvaliacoes) / numAvaliacoes);
    }

    public void atualizarNumVisualizacoes() {
        this.numVisualizacoes++;
    }

    public long getMediaAvaliacoes() {
        return this.mediaAvaliacoes;
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