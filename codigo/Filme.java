package codigo;

public class Filme extends Conteudo {
    private double duracao;

    /**
     * Construtor da classe Filme
     * 
     * @param id             O id do filme a ser criado
     * @param nome           O nome do filme a ser criado
     * @param genero         O genero do filme a ser criado
     * @param idioma         O idioma do filme a ser criado
     * @param dataLancamento A data de lançamento do filme a ser criado
     * @param duracao        A duração do filme a ser criado
     * @param ehLancamento   Indicação se o filme é lançamento
     */
    public Filme(String id, String nome, String genero, String idioma, String dataLancamento, String duracao,
            boolean ehLancamento) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.duracao = converterDuracaoDeMinutosParaSegundos(Double.parseDouble(duracao));
        this.ehLancamento = ehLancamento;
    }

    /**
     * Converte a duração do filme de minutos para segundos, visto que é
     * especificado na regra que a duração deve ser armazenada em segundos.
     * 
     * @param duracao A duração do filme em minutos.
     * @return A duração do filme convertida para segundos.
     */
    private double converterDuracaoDeMinutosParaSegundos(double duracao) {
        return duracao * 60;
    }
}