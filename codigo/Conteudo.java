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

    /**
     * Método utilizado para realizar a lógica de avaliação por parte do conteúdo
     * (atualizar o número de avaliações e realizar o cálculo da nota média de
     * avaliações, atualizada com a nova avaliação adicionada)
     * 
     * @param notaAvaliacao A nota dada a avaliação
     */
    public void avaliarMidia(int notaAvaliacao) {
        if (notaAvaliacao < Avaliacao.NOTA_MIN_AVALIACAO || notaAvaliacao > Avaliacao.NOTA_MAX_AVALIACAO) {
            return;
        }
        numAvaliacoes++;
        recalcularAvaliacaoMedia(notaAvaliacao);
    }

    /**
     * Método interno utilizado para recalcular a avaliação média, contando com a
     * nova avaliação adicionada. Utiliza a seguinte fórmula:
     * mediaAtualizada = mediaAntiga + ((novoValor - mediaAntiga) /
     * novaQuantidadeAvaliações)
     * 
     * @param notaNovaAvaliacao A nota da nova avaliação adicionada
     */
    private void recalcularAvaliacaoMedia(int notaNovaAvaliacao) {
        this.mediaAvaliacoes = this.mediaAvaliacoes + ((notaNovaAvaliacao - this.mediaAvaliacoes) / this.numAvaliacoes);
    }

    public long getMediaAvaliacoes() {
        return this.mediaAvaliacoes;
    }

    public int getNumVisualizacoes() {
        return this.numVisualizacoes;
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
