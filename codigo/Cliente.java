package codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Cliente {
    protected String nome;
    protected String username;
    protected String senha;
    protected List<Conteudo> conteudosAssistidos = new ArrayList<>();
    protected List<Conteudo> conteudosParaAssistir = new ArrayList<>();
    protected Map<String, Avaliacao> avaliacoes = new HashMap<>();

    /**
     * Construtor da classe cliente
     * 
     * @param username O nome de usuário do cliente a ser criado
     */
    protected Cliente(String username) {
        this.username = username;
    }

    /**
     * Construtor da classe cliente
     * 
     * @param nome     O nome do cliente a ser criado
     * @param username O nome de usuário do cliente a ser criado
     * @param senha    A senha do cliente a ser criado
     */
    protected Cliente(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }

    /**
     * Método abstrato de avalição de mídia. Método é abstrato pois a implementação
     * depende do tipo de cliente, seja ele especialista, profissional etc.
     * 
     * @param midia             A mídia a ser avaliada pelo cliente
     * @param notaAvaliacao     A nota da avaliação dada pelo cliente
     * @param mensagemAvaliacao A mensagem de avaliação deixada pelo cliente
     */
    public abstract void avaliarMidia(Conteudo midia, int notaAvaliacao, String mensagemAvaliacao);

    /**
     * Método para obter a quantidade de mídias assistidas pelo cliente.
     * 
     * @return A quantidade de mídias assistidas pelo cliente.
     */
    public int obterQuantidadeMidiasAssistidas() {
        return this.conteudosAssistidos.size();
    }

    /**
     * Método para obter a quantidade de avaliações que o cliente possui.
     * 
     * @return A quantidade de avaliações que o cliente possui.
     */
    public int obterQuantidadeAvaliacoes() {
        return this.avaliacoes.size();
    }

    /**
     * Método para checar se o nome de usuário e senha estão corretos.
     * 
     * @param username O nome de usuário do cliente
     * @param senha    A senha do cliente.
     * @return Verdadeiro caso as credenciais estejam corretas e falso caso estejam
     *         incorretas.
     */
    public boolean checarCredenciais(String username, String senha) {
        return username.equals(this.username) && senha.equals(this.senha);
    }

    /**
     * Método para assistir um conteúdo
     * 
     * @param conteudo O conteúdo que deseja assistir.
     */
    public void assistirConteudo(Conteudo conteudo) {
        if (!this.conteudosAssistidos.contains(conteudo)) {
            this.conteudosAssistidos.add(conteudo);
        }
    }

    /**
     * Método para adicionar conteúdo na lista de conteúdos para assistir.
     * 
     * @param conteudo O conteúdo que deseja adicionar na lista de conteúdos para
     *                 assistir.
     */
    public void adicionarListaConteudoParaAssistir(Conteudo conteudo) {
        if (!this.conteudosParaAssistir.contains(conteudo)) {
            this.conteudosParaAssistir.add(conteudo);
        }
    }

    /**
     * Método para remover conteúdo da lista de conteúdos para asssitir.
     * 
     * @param conteudo O conteúdo que deseja remover da lista de conteúdos para
     *                 assistir.
     * @return Verdadeiro caso tenha sido feita a remoção, e falso caso não tenha
     *         sido concluída, no caso de o cliente não possui esse conteúdo em sua
     *         lista de conteúdos para assistir.
     */
    public boolean removerListaConteudosParaAssistir(Conteudo conteudo) {
        if (this.conteudosParaAssistir.contains(conteudo)) {
            this.conteudosParaAssistir.remove(conteudo);
            return true;
        }
        return false;
    }

    /**
     * Método para buscar conteúdos assistidos filtrando por gênero.
     * 
     * @param genero O gênero em que deseja buscar.
     * @return Uma lista dos conteúdos que satisfazem a condição de serem do gênero
     *         especificado.
     */
    public List<Conteudo> buscarConteudoAssistidoPorGenero(Genero genero) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosAssistidos) {
            if (conteudo.getGenero().equals(genero)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    /**
     * Método para buscar conteúdos assistidos por nome.
     * 
     * @param nome O nome em que deseja buscar.
     * @return Uma lista dos conteúdos que satisfazem a condição do nome
     *         especificado.
     */
    public List<Conteudo> buscarConteudoAssistidoPorNome(String nome) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosAssistidos) {
            if (conteudo.nome.toLowerCase().contains(nome.toLowerCase())) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    /**
     * Método para buscar conteúdos assistidos por idioma.
     * 
     * @param idioma O idioma em que deseja buscar.
     * @return Uma lista dos conteúdos que satisfazem a condição do idioma
     *         especificado.
     */
    public List<Conteudo> buscarConteudoAssistidoPorIdioma(Idioma idioma) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosAssistidos) {
            if (conteudo.getIdioma().equals(idioma)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    /**
     * Método para buscar conteúdos a assistir filtrando por gênero.
     * 
     * @param genero O gênero em que deseja buscar.
     * @return Uma lista dos conteúdos para assistir que satisfazem a condição de
     *         serem do gênero especificado.
     */
    public List<Conteudo> buscarConteudoParaAssistirPorGenero(Genero genero) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosParaAssistir) {
            if (conteudo.getGenero().equals(genero)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    /**
     * Método para buscar conteúdos a assistir filtrando por nome.
     * 
     * @param nome O nome em que deseja buscar.
     * @return Uma lista dos conteúdos para assistir que satisfazem a condição de
     *         possuírem o nome especificado.
     */
    public List<Conteudo> buscarConteudoParaAssistirPorNome(String nome) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosParaAssistir) {
            if (conteudo.nome.toLowerCase().contains(nome.toLowerCase())) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    /**
     * Método para buscar conteúdos a assistir filtrando por idioma.
     * 
     * @param idioma O idioma em que deseja buscar.
     * @return Uma lista dos conteúdos para assistir que satisfazem a condição de
     *         serem do idioma especificado.
     */
    public List<Conteudo> buscarConteudoParaAssistirPorIdioma(Idioma idioma) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosParaAssistir) {
            if (conteudo.getIdioma().equals(idioma)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }
}