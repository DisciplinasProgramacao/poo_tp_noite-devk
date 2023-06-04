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

    protected Cliente(String username) {
        this.username = username;

    }

    protected Cliente(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }

    public abstract void avaliarMidia(Conteudo midia, int notaAvaliacao, String mensagemAvaliacao);

    public int obterQuantidadeMidiasAssistidas() {
        return this.conteudosAssistidos.size();
    }

    public int obterQuantidadeAvaliacoes() {
        return this.avaliacoes.size();
    }

    public boolean checarCredenciais(String username, String senha) {
        return username.equals(this.username) && senha.equals(this.senha);
    }

    public void assistirConteudo(Conteudo conteudo) {
        if (!this.conteudosAssistidos.contains(conteudo)) {
            this.conteudosAssistidos.add(conteudo);
        }
    }

    public void adicionarListaConteudoParaAssistir(Conteudo conteudo) {
        if (!this.conteudosParaAssistir.contains(conteudo)) {
            this.conteudosParaAssistir.add(conteudo);
        }
    }

    public void removerListaConteudosParaAssistir(Serie serie) {
        if (this.conteudosParaAssistir.contains(serie)) {
            this.conteudosParaAssistir.remove(serie);
        }
    }

    public List<Conteudo> buscarConteudoAssistidoPorGenero(String genero) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosAssistidos) {
            if (conteudo.getGenero().equals(genero)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    public List<Conteudo> buscarConteudoAssistidoPorNome(String nome) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosAssistidos) {
            if (conteudo.getGenero().equals(nome)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    public List<Conteudo> buscarConteudoAssistidoPorIdioma(String idioma) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosAssistidos) {
            if (conteudo.getIdioma().equals(idioma)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    public List<Conteudo> buscarConteudoParaAssistirPorGenero(String genero) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosParaAssistir) {
            if (conteudo.getGenero().equals(genero)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    public List<Conteudo> buscarConteudoParaAssistirPorNome(String nome) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosParaAssistir) {
            if (conteudo.getGenero().equals(nome)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }

    public List<Conteudo> buscarConteudoParaAssistirPorIdioma(String idioma) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Conteudo conteudo : this.conteudosParaAssistir) {
            if (conteudo.getIdioma().equals(idioma)) {
                conteudosFiltrados.add(conteudo);
            }
        }

        return conteudosFiltrados;
    }
}
