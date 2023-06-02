package codigo;

public class Serie extends Conteudo {
    private int qtdEpisodios = 0;

    /**
     * Construtor da classe Serie
     * 
     * @param id             O id da série a ser criada
     * @param nome           O nome da série a ser criada
     * @param genero         O genero da série a ser criada
     * @param idioma         O idioma da série a ser criada
     * @param dataLancamento A data de lançamento da série a ser criada
     */
    public Serie(String id, String nome, String genero, String idioma, String dataLancamento) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
    }

    /**
     * Construtor da classe Serie
     * 
     * @param id           O id da série a ser criada
     * @param nome         O nome da série a ser criada
     * @param genero       O genero da série a ser criada
     * @param idioma       O idioma da série a ser criada
     * @param qtdEpisodios A quantidade de episódios da série a ser criada
     * @param ehLancamento Indicador se a série é lançamento ou não
     */
    public Serie(String id, String nome, String genero, String idioma, int qtdEpisodios, boolean ehLancamento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
        this.qtdEpisodios = qtdEpisodios;
        this.ehLancamento = ehLancamento;
    }
}