package codigo;

public class Filme extends Conteudo {
    private double duracao;

    // Construtor da classe Filme
    public Filme(String id, String nome, String genero, String idioma, String dataLancamento, String duracao,
            boolean ehLancamento) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.duracao = converterDuracaoDeMinutosParaSegundos(Double.parseDouble(duracao));
        this.ehLancamento = ehLancamento;
    }

    // Converte a duração do filme de minutos para segundos, já que a duração deve
    // ser armazenada em segundos
    private double converterDuracaoDeMinutosParaSegundos(double duracao) {
        return duracao * 60;
    }
}