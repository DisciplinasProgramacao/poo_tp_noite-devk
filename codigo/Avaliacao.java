package codigo;

public class Avaliacao {
    public static final int NOTA_MIN_AVALIACAO = 1;
    public static final int NOTA_MAX_AVALIACAO = 5;
    private String idMidia;
    private String usernameUsuario;
    private int notaAvaliacao;
    private String mensagemAvaliacao;

    /**
     * Construtor da classe de Avaliacao
     * 
     * @param idMidia         O id da mídia avaliada nessa avaliação
     * @param usernameUsuario O nome do usuário que realizou a avaliação
     * @param notaAvaliacao   A nota dada pelo avaliador
     */
    public Avaliacao(String idMidia, String usernameUsuario, int notaAvaliacao) {
        this.idMidia = idMidia;
        this.usernameUsuario = usernameUsuario;
        this.notaAvaliacao = notaAvaliacao;
    }

    /**
     * Construtor da classe de Avaliacao
     * 
     * @param idMidia           O id da mídia avaliada nessa avaliação
     * @param usernameUsuario   O nome do usuário que realizou a avaliação
     * @param notaAvaliacao     A nota dada pelo usuário
     * @param mensagemAvaliacao A mensagem de avaliação deixada pelo avaliador.
     */
    public Avaliacao(String idMidia, String usernameUsuario, int notaAvaliacao, String mensagemAvaliacao) {
        this(idMidia, usernameUsuario, notaAvaliacao);
        this.mensagemAvaliacao = mensagemAvaliacao;
    }
}
