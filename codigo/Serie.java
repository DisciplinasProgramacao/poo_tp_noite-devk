package codigo;

public class Serie extends Conteudo {
    private int qtdEpisodios = 0;

    public Serie(String id, String nome, String genero, String idioma, String dataLancamento) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
    }

    // Construtor da classe Serie:
    public Serie(String id, String nome, String genero, String idioma, int qtdEpisodios, boolean ehLancamento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
        this.qtdEpisodios = qtdEpisodios;
        this.ehLancamento = ehLancamento;
    }
}