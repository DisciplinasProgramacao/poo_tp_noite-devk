package codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
    private String nome;
    private String username;
    private String senha;
    private String tipoCliente = TiposClientes.CLIENTE_REGULAR;
    private List<Serie> seriesAssistidas = new ArrayList<>();
    private List<Serie> seriesParaAssistir = new ArrayList<>();
    private Map<String, Avaliacao> avaliacoes = new HashMap<>();

    public Usuario(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }
    
    public void avaliarMidia(String idMidia, int notaAvaliacao, String mensagemAvaliacao) {
        if (notaAvaliacao < Avaliacao.NOTA_MIN_AVALIACAO|| notaAvaliacao > Avaliacao.NOTA_MAX_AVALIACAO) {
            return;
        }
        
        // Mídia já foi avaliada pelo usuário
        if (this.avaliacoes.get(idMidia) != null) {
            return;
        }

        // Pode avaliar com um comentario
        if (this.tipoCliente.equals(TiposClientes.CLIENTE_ESPECIALISTA)) {
            Avaliacao avaliacao = new Avaliacao(idMidia, this.username, notaAvaliacao, mensagemAvaliacao);
            avaliacoes.put(idMidia, avaliacao);
        } else {
            Avaliacao avaliacao = new Avaliacao(idMidia, this.username, notaAvaliacao);
            avaliacoes.put(idMidia, avaliacao);
        }

        if (!this.tipoCliente.equals(TiposClientes.CLIENTE_ESPECIALISTA) && avaliacoes.size() >= 5) {
            this.tipoCliente = TiposClientes.CLIENTE_ESPECIALISTA;
        }
    }

    public boolean checarCredenciais(String username, String senha) {
        return username.equals(this.username) && senha.equals(this.senha);
    }

    public void assistirSerie(Serie serie) {
        if (!this.seriesAssistidas.contains(serie)) {
            this.seriesAssistidas.add(serie);
        }
    }

    public void adicionarListaSeriesParaAssistir(Serie serie) {
        if (!this.seriesParaAssistir.contains(serie)) {
            this.seriesParaAssistir.add(serie);
        }
    }

    public void removerListaSeriesParaAssistir(Serie serie) {
        if (this.seriesParaAssistir.contains(serie)) {
            this.seriesParaAssistir.remove(serie);
        }
    }

    public List<Serie> buscarSerieAssistidaPorGenero(String genero) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Serie serie : this.seriesAssistidas) {
            if (serie.getGenero().equals(genero)) {
                seriesFiltradas.add(serie);
            }
        }

        return seriesFiltradas;
    }

    public List<Serie> buscarSerieAssistidaPorNome(String nome) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Serie serie : this.seriesAssistidas) {
            if (serie.getGenero().equals(nome)) {
                seriesFiltradas.add(serie);
            }
        }

        return seriesFiltradas;
    }

    public List<Serie> buscarSerieAssistidaPorIdioma(String idioma) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Serie serie : this.seriesAssistidas) {
            if (serie.getIdioma().equals(idioma)) {
                seriesFiltradas.add(serie);
            }
        }

        return seriesFiltradas;
    }

    public List<Serie> buscarSerieParaAssistirPorGenero(String genero) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Serie serie : this.seriesParaAssistir) {
            if (serie.getGenero().equals(genero)) {
                seriesFiltradas.add(serie);
            }
        }

        return seriesFiltradas;
    }

    public List<Serie> buscarSerieParaAssistirPorNome(String nome) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Serie serie : this.seriesParaAssistir) {
            if (serie.getGenero().equals(nome)) {
                seriesFiltradas.add(serie);
            }
        }

        return seriesFiltradas;
    }

    public List<Serie> buscarSerieParaAssistirPorIdioma(String idioma) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Serie serie : this.seriesParaAssistir) {
            if (serie.getIdioma().equals(idioma)) {
                seriesFiltradas.add(serie);
            }
        }

        return seriesFiltradas;
    }
}
