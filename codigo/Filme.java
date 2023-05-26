package codigo;

public class Filme {
    private int id;
    private String nome;
    private String genero;
    private String idioma;
    private int numVisualizacoes = 0;
    private long mediaAvaliacoes = 0;
    private int numAvaliacoes = 0;
    private String dataLancamento;
    private Double duracao;

    // Construtor da classe Filme
    public Filme(int id, String nome, String genero, String idioma, String dataLancamento, Double duracao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
    }
}