package codigo;

public abstract class Conteudo {
    protected String id;
    protected String nome;
    protected String genero;
    protected String idioma;
    protected int numVisualizacoes = 0;
    protected long mediaAvaliacoes = 0;
    protected int numAvaliacoes = 0;
    protected String dataLancamento;
    protected boolean ehLancamento = false;

    public void avaliarMidia(int notaAvaliacao) {
        if (notaAvaliacao < Avaliacao.NOTA_MIN_AVALIACAO || notaAvaliacao > Avaliacao.NOTA_MAX_AVALIACAO) {
            return;
        }
        numAvaliacoes++;
        recalcularAvaliacaoMedia(notaAvaliacao);
    }

    private void recalcularAvaliacaoMedia(int notaNovaAvaliacao) {
        this.mediaAvaliacoes = this.mediaAvaliacoes + ((notaNovaAvaliacao - this.mediaAvaliacoes) / numAvaliacoes);
    }

    public boolean getEhLancamento() {
        return this.ehLancamento;
    }

    public String getId() {
        return this.id;
    }

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
