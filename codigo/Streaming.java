package codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Streaming {
    private HashMap<Integer, Serie> series = new HashMap<>();
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private Usuario usuarioLogado;

    private void fazerLogin(String username, String senha) {
        Usuario usuario = this.usuarios.get(username);
        if (!usuario.checarCredenciais(username, senha)) {
            this.usuarioLogado = usuario;
        }
    }

    private List<Serie> buscarSeriePorGenero(String genero) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Map.Entry<Integer, Serie> serie : series.entrySet()) {
            if (serie.getValue().getGenero().equals(genero)) {
                seriesFiltradas.add(serie.getValue());
            }
        }

        return seriesFiltradas;
    }

    private List<Serie> buscarSeriePorNome(String nome) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Map.Entry<Integer, Serie> serie : series.entrySet()) {
            if (serie.getValue().getNome().equals(nome)) {
                seriesFiltradas.add(serie.getValue());
            }
        }

        return seriesFiltradas;
    }

    private List<Serie> buscarSeriePorIdioma(String idioma) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Map.Entry<Integer, Serie> serie : series.entrySet()) {
            if (serie.getValue().getIdioma().equals(idioma)) {
                seriesFiltradas.add(serie.getValue());
            }
        }

        return seriesFiltradas;
    }
}