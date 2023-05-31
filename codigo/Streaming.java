package codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Streaming {
    private HashMap<Integer, Serie> series = new HashMap<>();
    private HashMap<String, Cliente> usuarios = new HashMap<>();
    private Cliente usuarioLogado;

    //Verifica os dados do usuario pra fazer login
    private void fazerLogin(String username, String senha) {
        Cliente usuario = this.usuarios.get(username);
        if (!usuario.checarCredenciais(username, senha)) {
            return;
        }
        this.usuarioLogado = usuario;
    }

    //Percorre o array e retorna apenas o genero passado
    private List<Serie> buscarSeriePorGenero(String genero) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Map.Entry<Integer, Serie> serie : series.entrySet()) {
            if (serie.getValue().getGenero().equals(genero)) {
                seriesFiltradas.add(serie.getValue());
            }
        }

        return seriesFiltradas;
    }
    //Percorre o array e retorna apenas o nome passado
    private List<Serie> buscarSeriePorNome(String nome) {
        List<Serie> seriesFiltradas = new ArrayList<>();

        for (Map.Entry<Integer, Serie> serie : series.entrySet()) {
            if (serie.getValue().getNome().equals(nome)) {
                seriesFiltradas.add(serie.getValue());
            }
        }

        return seriesFiltradas;
    }

    //Percorre o array e retorna apenas o idioma passado
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