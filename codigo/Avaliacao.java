package codigo;

public class Avaliacao {
    public static final int NOTA_MIN_AVALIACAO = 1;
    public static final int NOTA_MAX_AVALIACAO = 5;
    private String idMidia;
    private String usernameUsuario;
    private int notaAvaliacao;
    private String mensagemAvaliacao;

    //Construtores da classe Avaliacao:
    public Avaliacao(String idMidia, String usernameUsuario, int notaAvaliacao) {
        this.idMidia = idMidia;
        this.usernameUsuario = usernameUsuario;
        this.notaAvaliacao = notaAvaliacao;
    }

    public Avaliacao(String idMidia, String usernameUsuario, int notaAvaliacao, String mensagemAvaliacao) {
        this(idMidia, usernameUsuario, notaAvaliacao);
        this.mensagemAvaliacao = mensagemAvaliacao;
    }
}
