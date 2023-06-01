package codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import codigo.Interfaces.ILeitorDeArquivo;

public class Streaming {
    private Map<String, Conteudo> conteudos = new HashMap<>();
    private Map<String, Cliente> usuarios = new HashMap<>();
    private ILeitorDeArquivo leitorDeArquivo;
    private Cliente usuarioLogado;

    // Injeção de dependência do leitor de arquivo
    public Streaming(ILeitorDeArquivo leitorDeArquivo) {
        this.leitorDeArquivo = leitorDeArquivo;
        this.popularDados();
    }

    private void popularDados() {
        try {
            this.conteudos = this.leitorDeArquivo.lerArquivosSerie();
            this.usuarios = this.leitorDeArquivo.lerArquivosEspectadores();
            this.leitorDeArquivo.lerArquivosAudiencia(this.usuarios, this.conteudos);
            this.leitorDeArquivo.lerArquivosFilme(this.conteudos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Verifica os dados do usuario pra fazer login
    private void fazerLogin(String username, String senha) {
        Cliente usuario = this.usuarios.get(username);
        if (!usuario.checarCredenciais(username, senha)) {
            return;
        }
        this.usuarioLogado = usuario;
    }

    // Percorre o array e retorna apenas o genero passado
    private List<Conteudo> buscarSeriePorGenero(String genero) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Map.Entry<String, Conteudo> conteudo : this.conteudos.entrySet()) {
            if (conteudo.getValue().getGenero().equals(genero)) {
                conteudosFiltrados.add(conteudo.getValue());
            }
        }

        return conteudosFiltrados;
    }

    // Percorre o array e retorna apenas o nome passado
    private List<Conteudo> buscarSeriePorNome(String nome) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Map.Entry<String, Conteudo> conteudo : this.conteudos.entrySet()) {
            if (conteudo.getValue().getNome().equals(nome)) {
                conteudosFiltrados.add(conteudo.getValue());
            }
        }

        return conteudosFiltrados;
    }

    // Percorre o array e retorna apenas o idioma passado
    private List<Conteudo> buscarSeriePorIdioma(String idioma) {
        List<Conteudo> conteudosFiltrados = new ArrayList<>();

        for (Map.Entry<String, Conteudo> conteudo : this.conteudos.entrySet()) {
            if (conteudo.getValue().getIdioma().equals(idioma)) {
                conteudosFiltrados.add(conteudo.getValue());
            }
        }

        return conteudosFiltrados;
    }
}