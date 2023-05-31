package codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Cliente {
    protected String nome;
    protected String username;
    protected String senha;
    protected String tipoCliente = TiposClientes.CLIENTE_REGULAR;
    protected List<Serie> seriesAssistidas = new ArrayList<>();
    protected List<Serie> seriesParaAssistir = new ArrayList<>();
    protected Map<String, Avaliacao> avaliacoes = new HashMap<>();

    public Cliente(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }
    
    public abstract void avaliarMidia(String idMidia, int notaAvaliacao, String mensagemAvaliacao);

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
